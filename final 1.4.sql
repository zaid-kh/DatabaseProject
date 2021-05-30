  drop database PAC ;

create database PAC;
use PAC;
create table Salesmen( #Ready for Sell and Reservation and perform
Job_ID int primary key,
Sname varchar(32),
S_ID int,#salesman ID
Address varchar(32),
Phone int
);

create table Customer( #Ready for sell and Reserve and perform and offer/ensure
Customer_ID int primary key,
Phone int,
Address varchar(32),
Bank_Statement bool,
Income_Proof bool
);

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


#create table After_sale( #ready for offer
#Service_Type varchar(32) primary key,
#Start_Date Date,
#End_Date Date
#); #CLEARED CUSTOMER_ID SINCE WE'RE INSERTING SERVICES VALID FOR ANY CUSTOMER, IT'S NOT ABOUT THE CUSTOMER IN THE ENTITY, BUT IN THE RELATION

create table Product( #ready for clear
Product_ID int primary key,
Price real,
P_Date Date, 
Cleared bool #customs
);




create table Car( # Ready for Reserves/License
Product_Id int primary key,
Vin varchar(32),
Color varchar(32),
Engine_Capacity int,
Transmission_Type varchar(32),
C_Type varchar(32),
C_Brand varchar(32),
Licensed bool
);


create table Part( # Ready for Product
Product_Id int primary key,
MPN varchar(32) #Manufacturer Part Number
);

create table Purchase_Order( #ready for perform/store
Order_No int primary key,
Quantity int,
Product_ID int
);

create table Promotions(
P_No int primary key,
Offers varchar(32), #discount, regular maintanance, ...
Starting_Date Date,
Ending_Date Date,
Duration int
);


create table Sale_Order( # Ready for sell
Order_ID int, 
Customer_ID int,
Job_ID int,
P_No int,
Down_payment real,
R_ID int,
primary key(Order_ID, R_ID)
);

create table OrderDetails( #For Quantity
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
foreign key (Product_ID) references car (Product_ID),
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


create table SaleOrder_Customer_Reservation_Ensure(
customer_ID int,
R_ID int,
Order_ID int,
foreign key (customer_ID) references customer (customer_ID),
foreign key (R_ID) references reservation (R_ID),
foreign key (Order_ID) references Sale_Order (Order_ID)
);



# Person 
ALTER TABLE Person ADD  foreign key(Customer_ID) references Customer(Customer_ID);

# Company
ALTER TABLE Company ADD  foreign key(Customer_ID) references Customer(Customer_ID);

# Reservation
ALTER TABLE Reservation ADD foreign key(Job_ID) references Salesmen(Job_Id);
ALTER TABLE Reservation ADD foreign key(Customer_ID) references Customer(Customer_ID);

# Car
ALTER TABLE Car ADD  FOREIGN KEY (Product_Id) REFERENCES Product (Product_Id);

# Part
ALTER TABLE Part ADD  foreign key (Product_Id) references Product(Product_Id);

# Customer

# Sale_Order
ALTER TABLE Sale_Order ADD  FOREIGN KEY (R_ID) REFERENCES Reservation (R_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (Customer_ID) REFERENCES Customer (Customer_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (Job_ID) REFERENCES Salesmen (Job_ID);
ALTER TABLE Sale_Order ADD  FOREIGN KEY (P_No) REFERENCES Promotions (P_No);




insert into Salesmen(Job_ID,sname,Address ,S_id, phone) values
(1, "Munther Anati", "Ramallah", 406123123, 059986543),
(2, "Yasmin Abusharbak", "Jifna", 406246246, 088743221),
(14, "Zaid khmais", "Jerusalem", 406345345, 0567748883),
(12, "Raya abu Hanish", "Tulkarm", 406567567, 0543322123),
(6, "Darwin Jacson", "AlBirah", 406246810, 05223543),
(88, "Roni Essa", "Birzeit", 406357357, 08887221),
(19, "Shaden Omar", "Rafat", 406246247, 05685483),
(93, "Sara Atallah", "Jenin", 406147258, 052783493);



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




insert into Person ( Customer_ID , P_Name, Age, Id) values
(6 , "ALi mostafa",22,21159965),
(7, "Majd Yaghmour",34,23445856),
(8 , "Fares Hallak",23,233166),
(9 , " Lamar Anati",55,315677),
(10 , "Huda Shadi",40,3455889);


insert into Company (Customer_ID , C_Name) values
(1 , "Orabi"),
(2 , "Abu Eisheh Motors"),
(3 , "Kerish Motors"),
(4 , "Nabali Motors"),
(5 , "Yasmin Motors");

insert into Reservation (R_ID, Job_ID, Customer_ID, Start_Date, End_Date) values
(103, 1, 8, '2020-04-14', '2020-04-29'),
(105, 2, 5, '2020-04-20', '2020-05-20'),
(108, 12, 10, '2020-05-03', '2020-05-18'),
(110, 14, 3, '2020-05-10', '2020-06-10'),
(111, 88, 4, '2020-06-15', '2020-07-15'),
(113, 93, 9, '2020-07-15', '2020-07-30');
-- 22:53:52	insert into Sale_Order (Order_ID, Customer_ID, Job_ID, P_No, Down_payment, R_ID) values (100, 8, 1, 1, 20000, 103), (101, 5, 2, 1, 30000, 105), (102, 10, 12, 1, 50000, 108), (103, 3, 14, 1, 35000, 110), (104, 4, 88, 1, 25000, 111), (105, 9, 93, 1, 20000, 113)	Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`pac`.`sale_order`, CONSTRAINT `sale_order_ibfk_4` FOREIGN KEY (`P_No`) REFERENCES `promotions` (`P_No`))	0.00054 sec


insert into Promotions (P_No, Offers, Starting_Date, Ending_Date, Duration) values #YYYY-MM-DD EDIT
(0, "No Promotion", '2020-10-10', '2020-10-10', 0),
(1, "Regular Maintenance", '2019-01-01', '2021-01-01', 5), 
(2, "Engine Air Filter", '2019-02-01', '2021-02-01', 6), 
(3, "Transmission Fluid Filter", '2019-03-15', '2021-08-15', 3), 
(4, "Tires Change", '2019-05-01', '2021-05-01', 4),
(5, "Discount", '2019-12-14', '2022-12-14', 0);



insert into Sale_Order (Order_ID, Customer_ID, Job_ID, P_No, Down_payment, R_ID) values
(100, 8, 1, 0, 20000, 103),
(101, 5, 2, 1, 30000, 105),
(102, 10, 12, 2, 50000, 108),
(103, 3, 14, 3, 35000, 110),
(104, 4, 88, 4, 25000, 111),
(105, 9, 93, 5, 20000, 113);




insert into Product (Product_ID,Price,Cleared) values
(40975, 130000, true),
(40978, 120000, false),
(40977, 160000,true),
(40976, 150000,false),
(40979, 144000,true),
(40981, 163000,false),
(40980, 124000,true),
(40999, 133000,false),
(40985, 112000,true),
(40984, 131000,false),
(70948,131000,false),
(70963, 131000,false),
(70996,131000,false),
(70984,131000,false),
(70912,131000,false);



insert into Car (Product_Id, Vin, Color, Engine_Capacity, Transmission_Type, C_Type, C_Brand, Licensed) values
(40975, "1GNEK13Z93R293940", "Red", 1600, "Automatic", "Sedan", "Hundai", TRUE),
(40978, "SCFAB22311K301756", "White", 1200, "Automatic", "Sport", "Fiat", TRUE),
(40977, "1XPWDBTX48D766660", "Black", 1600, "Automatic", "Hatchback", "Hundai", FALSE),
(40976, "JH4DB7550RS000461", "Blue", 1600, "Automatic", "SUV", "Jeep", FALSE),
(40979, "1GMDX03E8VD266902", "White", 1600, "Automatic", "Coupe", "Hundai", TRUE),
(40981, "4A3AB76T68E011282", "Silver", 1600, "Automatic", "Roadster", "Hundai", FALSE),
(40980, "JNKCV64E78M131002", "Black", 1600, "Automatic", "SUV", "Jeep", TRUE),
(40999, "JH4DA9360PS004131", "Black", 1600, "Automatic", "Sedan", "Fiat", FALSE),
(40985, "1G8ZH1277XZ105148", "White", 1600, "Automatic", "SUV", "Hundai", FALSE),
(40984, "5NPEC4ABXDH539433", "Red", 1600, "Automatic", "Sport", "Hundai", TRUE);


insert into Part (Product_Id, MPN) values
(70948, "HV-HM02"),
(70963, "HV-HM03"),
(70996, "HV-HM05"),
(70984, "HV-HN04"),
(70912, "HV-HM09");



insert into Customer_Get_ID_Promotions(Customer_id, P_No) values
(1, 1),
(2, 2),
(3, 5),
(4, 4),
(5, 3);


insert into Salesmen_Reserve_Car_Customer(customer_ID,job_Id,Product_ID)  values 
(8,1,40975),
(5,2,40978),
(10,12,40977),
(3,14,40976),
(4,88,40979),
(9,93,40980);

insert into OrderDetails(product_ID, Order_ID )values
(40975,100),
(40978,101),
(40977,102),
(40976,103),
(40979,104),
(40981,100),
(40980,101),
(40999,100),
(40985,102),
(40984,103);

insert into SaleOrder_Customer_Reservation_Ensure(customer_ID, R_ID, Order_ID) values
(8,103,100),
(5,105,101),
(10,108,102),
(3,110,103),
(4,111,104),
(9,113,105);

insert into Salesmen_Reservation_Customer(customer_ID, job_Id, R_ID)values
(8, 1, 103),
(5, 2, 105),
(10, 12, 108),
(3, 14, 110),
(4, 88, 111),
(9, 93, 113);