#!/bin/bash

echo "Ejecutar build"
./gradlew build
echo "Ejecutar docker build"
docker build . -t img-back-calculator:1.0.0
echo "listar imagenes"
docker images
echo "ejecutar imagen back-calculator"
docker run -d -p 8080:8080 img-back-calculator:1.0.0
echo "revisar imagen en ejecucion"
docker ps
echo "eliminar carpeta build"
rm -r build/





