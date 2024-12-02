CREATE TABLE Pet (
    Id UUID NOT NULL PRIMARY KEY
    name NOT NULL VARCHAR(100)
    age NOT NULL INT
    created_at NOT NULL DATE
    updated_at NOT NULL DATE
    pet_owner_id UUID
    species VARCHAR(45)
    size VARCHAR(45)
    CONSTRAINT fk_pet_owner FOREIGN KEY (pet_owner_id) REFERENCES PetOwner (Id)

);