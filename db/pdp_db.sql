DROP TABLE IF EXISTS patient CASCADE;
CREATE TABLE patient (
	patient_id uuid NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (patient_id),

    patient_wallet_address varchar(64) NOT NULL
);

DROP TABLE IF EXISTS dataset CASCADE;
CREATE TABLE dataset (
	dataset_id uuid NOT NULL,
    CONSTRAINT dataset_pk PRIMARY KEY (dataset_id),

	patient_id uuid NOT NULL,
	CONSTRAINT dataset_fk FOREIGN KEY (patient_id) REFERENCES patient(patient_id),

    dataset_address varchar(64) NOT NULL,

    dataset_price float8 NOT NULL,
    dataset_volume float8 NOT NULL,
    dataset_description varchar(255) NOT NULL
);

DROP TABLE IF EXISTS researcher CASCADE;
CREATE TABLE researcher (
	researcher_id uuid NOT NULL,
    CONSTRAINT researcher_pk PRIMARY KEY (researcher_id),

    researcher_wallet_address varchar(64) NOT NULL
);

DROP TABLE IF EXISTS research_application CASCADE;
CREATE TABLE research_application (
	app_id uuid NOT NULL,
    CONSTRAINT app_pk PRIMARY KEY (app_id),

	researcher_id uuid NOT NULL,
	CONSTRAINT dataset_researcher_fk FOREIGN KEY (researcher_id) REFERENCES researcher(researcher_id),

    app_address varchar(64) NOT NULL,

    app_name varchar(64) NOT NULL,
    app_description varchar(255)
);

    DROP TABLE IF EXISTS dataset_request CASCADE;
    CREATE TABLE dataset_request (
        dataset_request_id uuid NOT NULL,
        CONSTRAINT request_pk PRIMARY KEY (dataset_request_id),

        dataset_id uuid NOT NULL,
        CONSTRAINT dataset_fk FOREIGN KEY (dataset_id) REFERENCES dataset(dataset_id),

        researcher_id uuid NOT NULL,
        CONSTRAINT dataset_researcher_fk FOREIGN KEY (researcher_id) REFERENCES researcher(researcher_id),

        patient_dataset_address varchar(64) NOT NULL,
        researcher_app_address varchar(64) NOT NULL,

        dataset_request_info varchar(255),
        dataset_request_status varchar(64)

    );

DROP TABLE IF EXISTS task CASCADE;
CREATE TABLE task (
	task_id uuid NOT NULL,
    CONSTRAINT task_pk PRIMARY KEY (task_id),

	researcher_id uuid NOT NULL,
	CONSTRAINT dataset_researcher_fk FOREIGN KEY (researcher_id) REFERENCES researcher(researcher_id),

	dataset_id uuid NOT NULL,
	CONSTRAINT dataset_fk FOREIGN KEY (dataset_id) REFERENCES dataset(dataset_id),

    task_address varchar(255) NOT NULL,

	app_id uuid NOT NULL,
	CONSTRAINT app_fk FOREIGN KEY (app_id) REFERENCES research_application(app_id),

    task_description varchar(255)
);


ALTER TABLE dataset_request ADD COLUMN status varchar(64);
