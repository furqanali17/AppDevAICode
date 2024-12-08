-- Insert households
INSERT INTO household (eircode, address, number_occupants, max_occupants, owner_occupied) VALUES ('E123', '123 Main St', 3, 5, true);
INSERT INTO household (eircode, address, number_occupants, max_occupants, owner_occupied) VALUES ('E456', '456 Elm St', 2, 4, false);

-- Insert pets
INSERT INTO pet (name, household_eircode) VALUES ('Buddy', 'E123');
INSERT INTO pet (name, household_eircode) VALUES ('Mittens', 'E123');
