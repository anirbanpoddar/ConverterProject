The ConverterProject application explains the conversion logic from one form of input structure to another. Output structure is defined by the business domain model. The converter takes input in one form and generates outputs in another. Only one instance of a converter can be created. The application can be run from the test classes. There are two test classes through the application can be run. One shows the normal flow of execution and another is to show the behavior in multithreaded environment. Additionally, there is a JUNIT class for the testing of the utility class.

The input and output structure are simple and hypothetical. Only the input XML structure is implemented along with the XSD validation. Output is in txt format and on console. The domain model or the output consists of two main entities ? company and employee. Employee is divided into two sub types ? global and local. A company consists of employees. 

XML inputs provide nodes of companies with company data and the employee nodes within it. A company can exist without any employee. There can be multiple companies and same company can occur multiple times. In case of occurrence of same company multiple times, company information is overridden in the model. Employees can only be added or updated within the company if new information comes later. 

Primary key of the company is name and primary key of the employee is email. These two primary keys are used to identify the entities and these cannot be modified. There are validations provided for all the attributes except the address. There is a property file to set some configurable properties of the output. 

The output shows all the companies once with all information and employees within it.
