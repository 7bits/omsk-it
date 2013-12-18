ALTER TABLE user ADD first_name  varchar ( 255 ) NOT NULL;
ALTER TABLE user ADD second_name  varchar ( 255 ) NOT NULL;
ALTER TABLE user ADD email  varchar ( 255 ) NOT NULL;
ALTER TABLE user ADD jobPosition  varchar ( 255 ) NOT NULL;

ALTER TABLE guest DROP first_name;
ALTER TABLE guest DROP second_name;
ALTER TABLE guest DROP email;
ALTER TABLE guest DROP job_position;
ALTER TABLE guest DROP job;


