create database PAC;
use PAC;

create table Salesmen( #Ready for Sell and Reservation and perform
Job_ID int primary key,
Customer_ID int ,
order_Id int ,
product_Id int,
R_ID int,
Sname varchar(32),
S_ID int,#salesman ID
Address varchar(32),
Phone int
);

insert into Salesmen(Job_ID,sname,Address ,S_id, phone) values
(1,"muntherr anati", "Ramallah123",211599234,059986543),
(2,"Yasmin Shadi", "Jifna33",12334556,088743221),
(14,"Zaid khmais", "Jerusalem",112335442,0567748883),
(12,"Raya abu hanish", "Nablus",98844883,0543322123),
(6,"Darwin", "albirah",9023420,05223543),
(88,"Roni Dsa", "birzeit",2345332,08887221),
(19,"Shai Keki", "rafat",2383894,05685483),
(93,"Sara jkl", "Jenin",9879484,052783493);

select * from salesmen;
 
#create table PAC( #ready for offer/ clear/ License
#Company_Code varchar(32) primary key,
#Address varchar(32),
#Phone int,
#Service_Type varchar(32),
#Customer_ID int,
#CustomsP_Id int,
#Product_ID int,
#T_Address varchar(32)
#);

#create table Traffic_Department( #license
#Address varchar(32) primary key,
#Product_ID int,
#Company_Code varchar(32)
#);

create table Person( #ready insertion
Customer_ID int primary key,
Id int,
Age int, 
P_Name varchar(32)
);

create table Company( #ready insertion
Customer_ID int primary key,
C_Name varchar(32)
);

create table Reservation( #ready for perform/ ensure
	R_ID int primary key ,
    Job_ID int, #must
    Customer_ID int, #must
    Start_date date,
    End_date date
);

create table After_sale( #ready for offer
Service_Type varchar(32) primary key,
Start_Date Date,
End_Date Date,
Customer_ID int #must
);

#create table Customs_clearance( #ready for clear
#CustomsP_Id int primary key,
#Product_Price real,
#Product_Type varchar(32),
#Company_Code varchar(32),
#Product_ID int
#);

create table Car( # Ready for Reserves/License
Product_Id int primary key,
Vin varchar(32),
Color varchar(32),
Engine_Capacity int,
Transmission_Type varchar(32),
Licensed bool
);

create table Part( # Ready for Product
Product_Id int primary key,
P_Id int
);

create table Purchase_Order( #ready for perform/store
Order_No int primary key,
Quantity int,
Product_ID int
);

create table Customer( #Ready for sell and Reserve and perform and offer/ensure
Customer_ID int primary key,
Phone int,
Address varchar(32),
Bank_Statement bool,
Income_Proof bool
);

insert into Customer (Customer_ID, Phone, Address, Bank_Statement, Income_Proof) values
(1, 0597123123, "Ramallah", True, True),
(2, 0598125125,"Nablus", True, False),
(3, 0597225588, "Hebron", False, True),
(4, 0594171717, "Ramallah", True, False),
(5, 0596323538, "Jerusalem", False, True),
(6, 0592474543, "Ramallah", True, False),
(7, 0598141714, "Nablus", False, True),
(8, 0597246810, "Jericho", True, True),
(9, 0594123456, "Haifa", True, False),
(10, 0596000555, "Jerusalem", False, True);

insert into Person ( Customer_ID , P_Name, Age, Id) value
(6 , "ALi mostafa",22,211599685),
(7, "Majd Yaghmour",34,2344567856),
(8 , "Fares Hallak",23,233144566),
(9 , " Lamar Anati",55,311455677),
(10 , "Huda Shadi",40,345567889);

insert into Company (Customer_ID , C_Name) value
(1 , "Orabi"),
(2 , "Abu Eisheh Motors"),
(3 , "Kerish Motors"),
(4 , " Nabali Motors"),
(5 , "Yasmin Motors");

create table Product( #ready for clear
Product_ID int primary key,
Model varchar(32),
P_Name varchar(32),
Price real,
P_Date Date, 
Cleared bool #customs
);

create table Promotions(
P_No int primary key,
Offers varchar(32), #discount, regular maintanance, ...
Starting_Date Date,
Ending_Date Date
);

create table Sale_Order( # Ready for sell
Order_ID int,
Customer_ID int,
Job_ID int,
P_No int,
Down_payment real,
Quantity int,
R_ID int,
Product_ID int,
primary key(Order_ID, R_ID)
);

create table Quantity_PO(
product_ID int,
Order_ID int,
foreign key (Order_ID) references sale_order (Order_ID),
foreign key (Product_ID) references product (Product_ID)
);

create table Customer_Get_ID_Promotions(
Customer_id int,
P_No int,
foreign key (customer_id) references Customer (customer_id),
foreign key (P_No) references Promotions (P_No)
);

create table Salesmen_Reserve_Car_Customer(
customer_ID int,
job_Id int,
Product_ID int,
primary key( job_Id, Product_ID,customer_ID),
foreign key (job_Id) references salesmen (job_Id),
foreign key (Product_ID) references Car (Product_ID),
foreign key (customer_ID) references customer (customer_ID)
);

create table Salesmen_Reservation_Customer(
customer_ID int,
job_Id int,
R_ID int,
primary key( job_Id, R_ID,customer_ID),
foreign key (job_Id) references salesmen (job_Id),
foreign key (customer_ID) references customer (customer_ID),
foreign key (R_ID) references reservation (R_ID)
);

create table PAC_Offer_AfterSale_Customer(
customer_ID int,
Company_Code varchar(32),
Service_Type varchar(32),
foreign key (customer_ID) references customer (customer_ID),
foreign key (Company_Code) references PAC (Company_Code),
foreign key (Service_Type) references After_Sale (Service_Type)
);

create table PAC_CustomsClearance_Product(
Company_Code varchar(32),
CustomsP_ID int,
Product_ID int,
foreign key (Company_Code) references PAC (Company_Code),
foreign key (CustomsP_ID) references Customs_Clearance (CustomsP_ID),
foreign key (Product_ID) references Product (Product_ID)
);

create table PAC_TrafficDepartment_Car(
Company_Code varchar(32),
Address varchar(32),
Product_ID int,
foreign key (Company_Code) references PAC (Company_Code),
foreign key (Address) references Traffic_Department (Address),
foreign key (Product_ID) references Car (Product_ID)
);

create table SaleOrder_Customer_Reservation_Ensure(
customer_ID int,
R_ID int,
Order_ID int,
foreign key (customer_ID) references customer (customer_ID),
foreign key (R_ID) references reservation (R_ID),
foreign key (Order_ID) references Sale_Order (Order_ID)
);

# Salesman
ALTER TABLE Salesmen ADD  FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID);
ALTER TABLE Salesmen ADD  FOREIGN KEY (order_Id) references Sale_order(order_Id);
ALTER TABLE Salesmen ADD  FOREIGN KEY (product_Id) references car(product_Id);
ALTER TABLE Salesmen ADD  FOREIGN KEY (R_Id) references Reservation(R_Id);
# PAC
ALTER TABLE PAC ADD foreign key(Customer_ID) references Customer(Customer_ID);
ALTER TABLE PAC ADD foreign key(Service_Type) references After_Sale(Service_Type);
ALTER TABLE PAC ADD foreign key(CustomsP_Id) references Customs_Clearance(CustomsP_Id);
ALTER TABLE PAC ADD foreign key(Product_ID) references Product(Product_ID);
ALTER TABLE PAC ADD foreign key(Product_ID) references Car(Product_ID);
ALTER TABLE PAC ADD foreign key(T_Address) references Traffic_Department(Address);
# Traffic Departmant
ALTER TABLE Traffic_Department ADD foreign key(Product_ID) references Car(Product_ID);
ALTER TABLE Traffic_Department ADD foreign key(Company_Code) references PAC(Company_Code);

# Person 
ALTER TABLE Person ADD  foreign key(Customer_ID) references Customer(Customer_ID);

# Company
ALTER TABLE Company ADD  foreign key(Customer_ID) references Customer(Customer_ID);

# Reservation
ALTER TABLE Reservation ADD foreign key(Job_ID) references Salesmen(Job_Id);
ALTER TABLE Reservation ADD foreign key(Customer_ID) references Customer(Customer_ID);
ALTER TABLE Reservation ADD foreign key(Receipt_No) references Financial_Stuff(Receipt_No);

# Financial Stuff
ALTER TABLE Financial_Stuff ADD foreign key(R_ID) references Reservation(R_Id);
ALTER TABLE Financial_Stuff ADD foreign key(Customer_ID) references Customer(Customer_ID);

# After_sale
ALTER TABLE After_sale ADD foreign key(Company_code) references PAC(Company_code);
ALTER TABLE After_sale ADD foreign key(Customer_ID) references Customer(Customer_ID);

# customs_clearance
ALTER TABLE customs_clearance ADD foreign key(Company_code) references PAC(Company_code);
ALTER TABLE customs_clearance ADD foreign key(Product_ID) references Product(Product_ID);

# car
ALTER TABLE Car ADD  FOREIGN KEY (Product_Id) REFERENCES Product (Product_Id);
ALTER TABLE Car ADD  FOREIGN KEY (Address) REFERENCES Traffic_Department (Address);
ALTER TABLE Car ADD  FOREIGN KEY (customer_ID) REFERENCES customer (customer_ID);
ALTER TABLE Car ADD  FOREIGN KEY (company_code) REFERENCES PAC (company_code);
ALTER TABLE Car ADD  FOREIGN KEY (Job_id) REFERENCES Salesmen (Job_id);

# part
ALTER TABLE Part ADD  foreign key (Product_Id) references Product(Product_Id);


# Customer
ALTER TABLE Customer ADD  FOREIGN KEY (Order_ID) REFERENCES sale_Order (Order_ID);
ALTER TABLE Customer ADD  FOREIGN KEY (Job_ID) REFERENCES Salesmen (Job_ID);
ALTER TABLE Customer ADD  FOREIGN KEY (product_Id) REFERENCES car (product_Id);
ALTER TABLE Customer ADD  FOREIGN KEY (R_Id) REFERENCES reservation (R_Id);
ALTER TABLE Customer ADD  FOREIGN KEY (Company_Code) REFERENCES PAC (Company_Code);
ALTER TABLE Customer ADD  FOREIGN KEY (Receipt_NO) REFERENCES Financial_stuff (Receipt_NO);
ALTER TABLE Customer ADD  FOREIGN KEY (Service_Type) REFERENCES After_Sale (Service_Type);

# Product
ALTER TABLE Product ADD  FOREIGN KEY (CustomsP_ID) REFERENCES Customs_clearance (CustomsP_ID);
ALTER TABLE Product ADD  FOREIGN KEY (Company_Code) REFERENCES PAC (Company_Code);

# Sale_Order
ALTER TABLE Sale_Order ADD  FOREIGN KEY (R_ID) REFERENCES Reservation (R_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (Job_ID) REFERENCES Salesmen (Job_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (P_No) REFERENCES Promotions (P_No);