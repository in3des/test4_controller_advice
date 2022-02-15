TRUNCATE TABLE
    forms,
    form_sectors
    CASCADE;

ALTER SEQUENCE forms_id_seq RESTART WITH 1;