-- Creación de la tabla 'autores'
CREATE TABLE autores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    activo BOOLEAN NOT NULL
);

-- Creación de la tabla 'topicos'
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje TEXT,
    fecha_creacion TIMESTAMP NOT NULL,
    estatus BOOLEAN NOT NULL,
    autor_id BIGINT,
    curso VARCHAR(255) NOT NULL,
    activo BOOLEAN NOT NULL,
    fecha_actualizacion TIMESTAMP,
    CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES autores(id)
);