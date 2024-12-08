-- Create Household table
CREATE TABLE household (
                           eircode VARCHAR(255) PRIMARY KEY,
                           address VARCHAR(255) NOT NULL,
                           number_occupants INT NOT NULL,
                           max_occupants INT NOT NULL,
                           owner_occupied BOOLEAN NOT NULL
);


-- Create Pet table
CREATE TABLE pet (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(255) NOT NULL,
                     household_eircode VARCHAR(255) NOT NULL,
                     CONSTRAINT fk_household
                         FOREIGN KEY (household_eircode)
                             REFERENCES household (eircode)
                             ON DELETE CASCADE
);

