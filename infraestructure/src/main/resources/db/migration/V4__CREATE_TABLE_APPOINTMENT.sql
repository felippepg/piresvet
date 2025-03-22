CREATE TABLE Appointment (
    Id UUID NOT NULL PRIMARY KEY,
    expected INT NOT NULL,
    services VARCHAR(45) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    pet_id UUID,
    vet_id UUID,
    size VARCHAR(45),
    CONSTRAINT fk_vet FOREIGN KEY (vet_id) REFERENCES Vet(Id),
    CONSTRAINT fk_pet FOREIGN KEY (pet_id) REFERENCES Pet(Id)
);
