<<<<<<< HEAD
# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
=======
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
>>>>>>> e9409d1f835f3b2dc2bf61e36006277567ee84b2
