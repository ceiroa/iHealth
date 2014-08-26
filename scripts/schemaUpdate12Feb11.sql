use ihealth;

alter table cervicalSpineVisits modify inspection varchar(1200);
alter table cervicalSpineVisits modify palpation varchar(1600);
alter table cervicalSpineVisits modify dxAction varchar(1600);

alter table lowerExtremitiesVisits modify inspection varchar(1200);
alter table lowerExtremitiesVisits modify palpation varchar(1600);
alter table lowerExtremitiesVisits modify dxAction varchar(1600);

alter table lumbarSpineVisits modify inspection varchar(1200);
alter table lumbarSpineVisits modify palpation varchar(1600);
alter table lumbarSpineVisits modify dxAction varchar(1600);

alter table upperExtremitiesVisits modify inspection varchar(1200);
alter table upperExtremitiesVisits modify palpation varchar(1600);
alter table upperExtremitiesVisits modify dxAction varchar(1600);