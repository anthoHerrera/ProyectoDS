CREATE DATABASE lineaBlancaSA;
USE lineaBlancaSA;

CREATE TABLE Local (
    idLocal varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    direccion varchar(50) NOT NULL,
    tipo varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idLocal)
);

CREATE TABLE Articulo (
    idArticulo varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    descripcion varchar(50) NOT NULL,
    modelo varchar(50) NOT NULL,
    precio FLOAT NOT NULL,
    tamano varchar(50),
    color varchar(50),
    maxTemp INT,
    capacidadMaxima INT,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idArticulo)
);

CREATE TABLE Inventario (
    idInventario varchar(50) NOT NULL,
    idLocal varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idInventario),
    FOREIGN KEY(idLocal) REFERENCES Local(idLocal)
    
);

CREATE TABLE InventarioStock (
	idStock varchar(50) NOT NULL,
    idInventario varchar(50) NOT NULL,
    idArticulo varchar(50) NOT NULL,
    cantidadArticulo INT NOT NULL,
    isVisible BOOLEAN NOT NULL,
    PRIMARY KEY(idStock),
    FOREIGN KEY(idInventario) REFERENCES Inventario(idInventario),
    FOREIGN KEY(idArticulo) REFERENCES Articulo(idArticulo)
    
);


CREATE TABLE Cliente (
    cedula varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    telefono varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (cedula)
);

CREATE TABLE Empleado (
    cedula varchar(50) NOT NULL,
    idLocal varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    telefono varchar(50) NOT NULL,
    tipo varchar(50) NOT NULL,
    usuario varchar(50) NOT NULL,
    clave varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (cedula),
    FOREIGN KEY(idLocal) REFERENCES Local(idLocal)
    
);

CREATE TABLE Transaccion (
<<<<<<< HEAD
    idTransaccion SERIAL NOT NULL,
=======
    idTransaccion auto_increment NOT NULL,
    idLocal varchar(50) NOT NULL,
>>>>>>> 2109db0256af663c2a26019b7f729c4433071341
    tipo varchar(50) NOT NULL,
    fecha DATE NOT NULL,
    idEmpleado varchar(50) NOT NULL,
    idCliente varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idTransaccion),
    FOREIGN KEY(idLocal) REFERENCES Local(idLocal),
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY(idEmpleado) REFERENCES Empleado(idEmpleado)
    
);

CREATE TABLE ArticulosTransaccion (
    idArticulosTransaccion SERIAL NOT NULL,
    idTransaccion SERIAL NOT NULL,
    idArticulo varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idArticulosTransaccion),
    FOREIGN KEY(idTransaccion) REFERENCES Transaccion(idTransaccion)
);
