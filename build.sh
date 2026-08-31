#!/bin/bash
set -e

echo "=== 1) Construyendo imagen BASE (myapp-base:1.0) ==="
docker build -t myapp-base:1.0 ./base

echo "=== 2) Construyendo imagen APP (myapp:1.0), basada en myapp-base:1.0 ==="
docker build -t myapp:1.0 ./app

echo ""
echo "Imágenes construidas:"
docker images | grep -E "myapp-base|myapp"

echo ""
echo "Para correr el aplicativo:"
echo "  docker run -d --name myapp-container -p 8081:8081 myapp:1.0"
