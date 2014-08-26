--Create test account
insert into users(firstName, lastName, username, password,
userType, email, status, dateCreated, dateUpdated)
values('John', 'Schmitt', 'test', md5('test'), 'admin',
'fake@gmail.com', 'active', NULL, NULL);

insert into users(firstName, lastName, username, password,
userType, email, status, dateCreated, dateUpdated)
values('Pete', 'Peterson', 'test2', md5('test2'),'nonadmin',
'fake@yahoo.es', 'active', NULL, NULL);

/*INSERT INTO cervicalSpineVisits(
    clientId,
    dateCreated,
    dateUpdated,
    sameComplaint,
    painChange,
    achingDullSore,
    burning,
    numbnessTingling,
    sharpShooting,
    sharpStabbing,
    stiffnessTightness,
    swelling,
    throbbing,
    snapPopGrind,
    painLevel,
    complaint,
    frequency
) VALUES (
    2,
    NULL,
    NULL,
    'yes',
    'better',
    'yes',
    'no',
    'no',
    'no',
    'no',
    'no',
    'no',
    'no',
    'no',
    2,
    'sdfsdfsd',
    'wefwegw fwwef wefwe'
);*/