use ihealth;

alter table cervicalSpineVisits alter column dateCreated drop default;

alter table lowerExtremitiesVisits alter column dateCreated drop default;

alter table lumbarSpineVisits alter column dateCreated drop default;

alter table upperExtremitiesVisits alter column dateCreated drop default;