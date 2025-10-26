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

# Run the code 