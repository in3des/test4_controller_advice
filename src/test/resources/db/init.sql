CREATE TABLE IF NOT EXISTS forms
(
    id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    agreement bool NOT NULL,
    username varchar(255) NOT NULL,
    CONSTRAINT forms_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS sectors
(
    id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    name varchar(255) NOT NULL,
    parent_id int8 NULL,
    CONSTRAINT sectors_pkey PRIMARY KEY (id),
    CONSTRAINT sectors_parent_fkey FOREIGN KEY (parent_id) REFERENCES sectors(id)
);

CREATE TABLE IF NOT EXISTS form_sectors
(
    form_id int8 NOT NULL,
    sector_id int8 NOT NULL,
    CONSTRAINT form_sectors_pkey PRIMARY KEY (form_id, sector_id),
    CONSTRAINT forms_fkey FOREIGN KEY (form_id) REFERENCES forms(id),
    CONSTRAINT sectors_fkey FOREIGN KEY (sector_id) REFERENCES sectors(id)
);
