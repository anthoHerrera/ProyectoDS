CREATE TABLE Local (
    idLocal varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    direccion varchar(50) NOT NULL,
    tipo varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idLocal)
);

CREATE TABLE Inventario (
    idInventario varchar(50) NOT NULL,
    idLocal varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idInventario),
    FOREIGN KEY(idLocal) REFERENCES Local(idLocal)
    
);

CREATE TABLE Articulo (
    idArticulo varchar(50) NOT NULL,
    nombre varchar(50) NOT NULL,
    descripcion varchar(50) NOT NULL,
    marca varchar(50) NOT NULL,
    precio FLOAT NOT NULL,
    tamano varchar(50),
    potenciaTotal varchar(50),
    inductores INT,
    voltaje varchar(50),
	cantidadPuertas int,
	capacidad int,
	filtroAgua varchar(50),
	nivelesTemperatura int,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idArticulo)
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

CREATE TABLE Transaccion (
    idTransaccion SERIAL NOT NULL,
    tipo varchar(50) NOT NULL,
    fecha DATE NOT NULL,
    idEmpleado varchar(50) NOT NULL,
    idCliente varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idTransaccion),
    FOREIGN KEY (idEmpleado) REFERENCES usuario(usuario),
	FOREIGN KEY (idCliente) REFERENCES Cliente(cedula)
    
);

CREATE TABLE ArticulosTransaccion (
    idArticulosTransaccion SERIAL NOT NULL,
    idTransaccion SERIAL NOT NULL,
    idArticulo varchar(50) NOT NULL,
	isVisible BOOLEAN NOT NULL,
    PRIMARY KEY (idArticulosTransaccion),
    FOREIGN KEY(idTransaccion) REFERENCES Transaccion(idTransaccion)
);

