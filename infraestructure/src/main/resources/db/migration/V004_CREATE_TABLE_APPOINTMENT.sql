CREATE TABLE Appointment (
    Id UUID NOT NULL PRIMARY KEY
    expected NOT NULL INT
    services  NOT NULL VARCHAR(45)
    created_at NOT NULL DATE
    updated_at NOT NULL DATE
    pet_owner_id UUID
    vet_id UUID
    size VARCHAR(45)
    CONSTRAINT fk_pet_owner FOREIGN KEY (pet_owner_id) REFERENCES PetOwner (Id)
    CONSTRAINT fk_vet FOREIGN KEY (vet_id) REFERENCES Vet (Id)
);