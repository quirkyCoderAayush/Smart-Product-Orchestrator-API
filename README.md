# Product Search Application

## Backend: Product Search API Service
### Overview
This is a Spring Boot RESTful API service that loads product data from an external dataset (dummyjson.com) into a local in-memory H2 database and provides endpoints to fetch products based on various criteria. The service includes free text search capabilities using Hibernate Search.
### Features
- Data orchestration from external API to in-memory H2 database
- Free text search across product attributes (name, description, etc.)
- Product lookup by ID
- RESTful API design following standard conventions
- Comprehensive API documentation with Swagger
### Tech Stack
- Java 17 or higher
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Hibernate Search with Lucene
- Lombok for reducing boilerplate code
- Swagger for API documentation
### API Endpoints
- `POST /api/v1/products/load` - Load data from external source to H2 DB
- `GET /api/v1/products/search?term={searchTerm}` - Free text search for products
- `GET /api/v1/products/{id}` - Find product by ID (e.g., MVCFH27F)
### Prerequisites
- Java 17 or higher
- Maven 3.8.x or higher
### Installation & Setup
1. Clone the repository
   ```bash
   git clone <repository-url>
   cd product-search-api
   ```
2. Build the application
   ```bash
   mvn clean install
   ```
3. Run the application
   ```bash
   mvn spring-boot:run
   ```
   The application will start on http://localhost:8080
### API Documentation
Once the application is running, Swagger UI documentation is available at:
- http://localhost:8080/swagger-ui.html
### Running Tests
```bash
# Run all tests
mvn test
# Run with coverage report
mvn verify
```
To run with a specific profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
### In-memory H2 Database
The H2 console is available at http://localhost:8080/h2-console when the application is running. Use these connection details:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`
### Free Text Search Implementation
The application uses Hibernate Search with Lucene for implementing free text search capabilities:
- Indexes are created for searchable fields (name, description, productId)
- Query parsing using Lucene's query syntax
- Result highlighting of matched terms

## Frontend: User Search Frontend Application
### Overview
This is a ReactJS-based Single Page Application (SPA) that provides a user-friendly interface for performing free text searches of products from the backend API. The application features client-side sorting and filtering capabilities, responsive design, and follows clean code practices.
### Features
- Google-like global search bar for searching products by name, description, or ID
- Auto-search triggering after 3 characters with additional recent search feature
- Grid display of search results
- Client-side sorting by price and name (ascending/descending)
- Client-side filtering by product category
- Responsive design for various device screens
- Lazy loading for improved performance
### Tech Stack
- ReactJS
- React Router for navigation
- Redux for state management
- Axios for API requests
- Jest and React Testing Library for unit testing
### Prerequisites
- Node.js (v14.0.0 or higher)
- npm (v6.0.0 or higher)
### Installation & Setup
1. Clone the repository
   ```bash
   git clone <repository-url>
   cd user-search-frontend
   ```
2. Install dependencies
   ```bash
   npm install
   ```
3. Create .env file in the root directory with the following variables
   ```
   REACT_APP_API_BASE_URL=http://localhost:8080/api/v1
   ```
4. Start the development server
   ```bash
   npm start
   ```
   The application will be available at http://localhost:3000
### Building for Production
```bash
npm run build
```
This will create an optimized production build in the `build` folder.
### Running Tests
```bash
# Run all tests
npm test
# Run tests with coverage report
npm run test:coverage
```
### Environment Configuration
The application supports multiple environments:
- Development: `.env.development`
- Testing: `.env.test`
- Production: `.env.production`
### Code Quality
- ESLint and Prettier are configured for code quality
- Husky pre-commit hooks ensure code quality before commits
- Jest for unit and integration testing
### Performance Optimizations
- React.lazy and Suspense for component lazy loading
- Debounced search input to minimize unnecessary API calls
- Memoized selectors with reselect for efficient state access
- Image optimization and lazy loading
### Browser Compatibility
The application is compatible with:
- Chrome (latest 2 versions)
- Firefox (latest 2 versions)
- Safari (latest 2 versions)
- Edge (latest 2 versions)
