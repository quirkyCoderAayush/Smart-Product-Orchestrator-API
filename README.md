# Smart-Product-Orchestrator-API

# Description
A resilient Spring Boot application that orchestrates product data from an external API to an in-memory H2 database. It provides robust RESTful APIs for product search and retrieval, integrates Resilience4j for fault tolerance, and is designed for scalability with Kubernetes.

Features
Data Orchestration: Load product data from an external API.
Free-Text Search: Search products by title and description.
Fetch by ID or SKU: Retrieve specific product details.
Resilience: Handles API failures with circuit breakers and fallbacks.
Swagger API Docs: Interactive documentation for endpoints.
Kubernetes Deployment: Scalable container orchestration.
CI/CD Pipeline: Automated build, test, and deployment using GitHub Actions.

# Technologies Used
Java 17 and Spring Boot
H2 Database (In-Memory)
Resilience4j for Circuit Breaker
Docker and Kubernetes
GitHub Actions for CI/CD
Prometheus and Grafana for Monitoring

# Setup and Run
Clone the Repository:

git clone https://github.com/your-username/ResilientProductOrchestrator.git
cd ResilientProductOrchestrator

Build the Application:

mvn clean package

Run Locally:

mvn spring-boot:run

Access Swagger Docs: Open http://localhost:8080/swagger-ui/index.html.

# Kubernetes Deployment
Build Docker Image:

docker build -t resilient-product-orchestrator:latest .

Apply Kubernetes Manifests:

kubectl apply -f deployment.yaml
kubectl apply -f service.yaml

Access Application: Use the external IP of the Kubernetes service.

# API Endpoints
POST /api/products/load: Load product data from the external API.
GET /api/products/search?query={text}: Search products by title/description.
GET /api/products/{idOrSku}: Retrieve product details by ID or SKU.
