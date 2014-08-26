/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ceiroa.controller;

import com.ceiroa.db.FileDB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martca05
 */
public class UploadServlet extends HttpServlet {

    //private static final String TMP_DIR_PATH = "C:\\Documents and Settings\\martca05\\My Documents\\NetBeansProjects\\iHealth\\tmp";
    private static String TMP_DIR_PATH ="";
    private File tmpDir;

    //private static final String DESTINATION_DIR_PATH ="C:\\Documents and Settings\\martca05\\My Documents\\NetBeansProjects\\iHealth\\files";
    private static String DESTINATION_DIR_PATH="";
    private File destinationDir;

    @Override
    public void init(ServletConfig config) throws ServletException {
            super.init(config);

            //String parentDir = new File("..").getAbsolutePath();
            //DESTINATION_DIR_PATH = parentDir + File.separator + "files";
            //TMP_DIR_PATH = parentDir + File.separator + "tmp";

            DESTINATION_DIR_PATH = "/Applications/Tomcat/files";
            TMP_DIR_PATH = "/Applications/Tomcat/tmp";

            tmpDir = new File(TMP_DIR_PATH);

            if(!tmpDir.isDirectory()) {
                    throw new ServletException(TMP_DIR_PATH + " is not a directory");
            }
            //String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
            //destinationDir = new File(realPath);
            destinationDir = new File(DESTINATION_DIR_PATH);
            if(!destinationDir.isDirectory()) {
                    throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
            } 
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("active", "manageUploads");

        String url = "/uploadFiles.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("active", "manageUploads");

        String clientId = request.getParameter("clientId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String postReqSource = request.getParameter("postReqSource");
        String numberOfFilesString = request.getParameter("numberOfFiles");

        int numberOfFiles = 0;
        if(numberOfFilesString!=null) {
            numberOfFiles = Integer.parseInt(numberOfFilesString);
            ArrayList numberOfFilesArray = new ArrayList();
            for(int i=1; i<=numberOfFiles; i++)
                    numberOfFilesArray.add(i);
            request.setAttribute("numberOfFilesArray", numberOfFilesArray);
        }
        request.setAttribute("clientId", clientId);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("numberOfFiles", numberOfFilesString);
 
        StringBuilder message = new StringBuilder();

        //If the request is coming from the uploadFiles.jsp page
        if (postReqSource == null || !postReqSource.equals("manageUploads")) {

            //Save files
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();

            //Set the size threshold, above which content will be stored on disk.
            fileItemFactory.setSizeThreshold(12 * 1024 * 1024); //12 MB

             //Set the temporary directory to store the uploaded files of size above threshold.
            fileItemFactory.setRepository(tmpDir);

            ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

            try {
                //Parse the request
                List items = uploadHandler.parseRequest(request);
                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem item = (FileItem) itr.next();
                    //Handle Form Fields.
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        if(fieldName.equals("clientId")) {
                            clientId = item.getString();
                        } else if (fieldName.equals("firstName")) {
                            firstName = item.getString();
                        } else if (fieldName.equals("lastName")) {
                            lastName = item.getString();
                        }
                    //Handle Uploaded files.
                    } else {
                        //Create Directory with Client Name
                        String destinationDirString = destinationDir.toString() 
                                + File.separator + firstName + " " + lastName;
                        File destinationDir2 = new File(destinationDirString);
                        if(!destinationDir2.exists()) {
                            destinationDir2.mkdir();
                        }
                        String fileName = item.getName();
                        if(fileName.length() > 40) {
                            String fileType = fileName.substring((fileName.length()-4),
                                    (fileName.length()));
                            String newFileName = fileName.substring(0, 36);
                            fileName = newFileName + fileType;
                        }
                        File file = new File(destinationDir2, fileName);

                        //Write file to the ultimate location.
                        item.write(file);
                        //If the item has been successfully uploaded, save information to the database
                        if(file.exists()) {
                            int result = FileDB.insert(clientId, file);
                            if(result==1) {
                                message.append("File ").append(file.getName()).append(" successfully uploaded.<br/>");
                            } else {
                                //Information was not inserted in the DB.
                                file.delete();
                                message.append("Problem inserting info for file ").append(file.getName()).append(" in database. Please try again or contact support.<br/>");
                            }
                        } else {
                            message.append("File could not be uploaded. Please try again or "
                                    + "contact support.<br/>");
                        }
                    }
                }
            } catch (FileUploadException ex) {
                message.append("Error encountered while parsing the request.");
            } catch (Exception ex) {
                message.append("Error encountered while uploading file.");
            }
        }

        request.setAttribute("infoMessage", message);

        //String currentDir = new File("..").getAbsolutePath();
        //currentDir = currentDir + "\\webapps\\files";
        //request.setAttribute("message", currentDir);
        
        String url = "/uploadFiles.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
