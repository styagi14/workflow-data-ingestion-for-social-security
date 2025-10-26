# workflow-data-ingestion-for-social-security
This is complete workflow repository for Social Security Department

---
## 🚀 Features
- Feature 1: Rest endpoint to insert user detailed information in postgresql and their document attachments in mongodb
- Feature 2: Data will be ingested from postgresql and mongodb to Azure ADLS Gen2 storage using ADF data pipeline
- Feature 3: Data will be cleaned, transformed and joined and then analytics will be applied for decision making on top of this data stored in delta tables in azure.

---

## 🧩 Installation

Step-by-step guide to install and run the code:

```bash
# Clone the repo
git clone https://github.com/styagi14/workflow-data-ingestion-for-social-security

# Go into the project folder
cd workflow-data-ingestion-for-social-security

## Steps to run the code 
- First run the docker-compose file to make postgresql and mongodb running local on your machine
- Run the spring boot rest project using java -jar workflow-data-ingestion-1.0-SNAPSHOT.jar
- Go to azure postal and create ADF workspace and create Linked Services, Data Sets to postgresql and mongodb and ADLS Gen2.
- Once we have data in ADLS Gen2, This is a raw formated data.
- We joined the user data and attachment and cleaned the data, joined and transformed the data.
- Next we need to create delta tables on top of it.
- Next we applied 
