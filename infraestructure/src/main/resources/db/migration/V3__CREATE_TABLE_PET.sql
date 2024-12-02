CREATE TABLE Pet (
    Id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    pet_owner_id UUID,
    species VARCHAR(45),
    size VARCHAR(45),
    CONSTRAINT fk_pet_owner FOREIGN KEY (pet_owner_id) REFERENCES PetOwner(Id)
);
