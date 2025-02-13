USE MASTER
GO

DROP DATABASE IF EXISTS medicineStore
GO

CREATE DATABASE medicineStore
GO

USE medicineStore
GO

CREATE TABLE account
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(30) NOT NULL,
	phone INT NOT NULL 
)
GO

CREATE TABLE drugType
(
	id VARCHAR(20) PRIMARY KEY NOT NULL,
	typeName VARCHAR(50) NOT NULL
)
GO

CREATE TABLE manufacturers
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	manu_name VARCHAR(50) NOT NULL,
	manu_address VARCHAR(50) NOT NULL,
	manu_phone INT NOT NULL
)
GO

CREATE TABLE drugs
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	typeId VARCHAR(20) FOREIGN KEY REFERENCES drugType(id),
	drug_name VARCHAR(50) NOT NULL,
	quantity INT NOT NULL,
	unit VARCHAR(20) NOT NULL,
	drug_price DECIMAL(10,3) NOT NULL,
	usage VARCHAR(20) NOT NULL,
	manuId INT FOREIGN KEY REFERENCES manufacturers(id),
	manuDay DATE NOT NULL,
	expireDay DATE NOT NULL,
	drugStatus BIT 
)
GO

CREATE TABLE customers
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	cus_name VARCHAR(30) NOT NULL,
	gender BIT NOT NULL,
	cus_phone INT NOT NULL
)
GO

CREATE TABLE payment
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	payMode VARCHAR(20) NOT NULL
)
GO

CREATE TABLE orders
(
	id INT PRIMARY KEY NOT NULL IDENTITY,
	cusId INT FOREIGN KEY REFERENCES customers(id),
	payId INT FOREIGN KEY REFERENCES payment(id),
	orderDate DATE NOT NULL,
	amountPaid DECIMAL(10,3) NOT NULL
)
GO

CREATE TABLE orderDetail
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	orderId INT FOREIGN KEY REFERENCES orders(id),
	drugId INT FOREIGN KEY REFERENCES drugs(id),
	priceEach DECIMAL(10,3) NOT NULL,
	quantity INT NOT NULL
)
GO

--- Login user function
CREATE PROC registerUser
@username VARCHAR(20), @password VARCHAR(30),@phone INT
AS
BEGIN
	IF NOT EXISTS(SELECT 1 FROM account WHERE username = @username)
		BEGIN
			INSERT INTO account(username,password,phone)
			VALUES(@username,@password,@phone)
		END
END
GO

CREATE PROC loginUser
@username VARCHAR(20), @password VARCHAR(30)
AS
BEGIN
	SELECT * FROM account
	WHERE username = @username AND password = @password
END
GO

CREATE PROC forgetPass
@password VARCHAR(30),@username VARCHAR(20),@phone INT
AS
BEGIN
	UPDATE account SET password = @password
	WHERE username = @username AND phone = @phone
END
GO

CREATE PROC checkExist
@username VARCHAR(20),@phone INT
AS
BEGIN
	SELECT 1 AS Result FROM account WHERE username = @username AND phone = @phone
END
GO

---- Drug function

CREATE PROC countDrug
AS
BEGIN
	SELECT COUNT(id) total FROM drugs
END 
GO
	
-- lay tu dong nao va lay bao nhieu dong 
CREATE PROC getDrug
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT drugs.id, drugs.typeId,drugs.drug_name,drugs.quantity,drugs.unit,drugs.drug_price,drugs.usage,manufacturers.manu_name,drugs.manuDay,drugs.expireDay,drugs.drugStatus
	FROM drugs
	INNER JOIN drugType
	ON drugs.typeId = drugType.id	
	INNER JOIN manufacturers
	ON drugs.manuId = manufacturers.id
	ORDER BY id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC updateDrug
@typeId VARCHAR(20),@drug_name VARCHAR(50), @quantity INT, @unit VARCHAR(20), @drug_price DECIMAL(10,3), @usage VARCHAR(20),@manuId INT, @manuDay DATE, @expireDay DATE, @status BIT,@id INT
AS
BEGIN
	UPDATE drugs
	SET typeId=@typeId,drug_name=@drug_name,quantity=@quantity,unit=@unit,drug_price=@drug_price,usage=@usage,manuId=@manuId,manuDay=@manuDay,expireDay=@expireDay,drugStatus=@status
	WHERE id= @id
END 
GO

CREATE PROC insertDrug
@typeId VARCHAR(20),@drug_name VARCHAR(50), @quantity INT, @unit VARCHAR(20), @drug_price DECIMAL(10,3), @usage VARCHAR(20),@manuId INT, @manuDay DATE, @expireDay DATE, @drugStatus BIT
AS
BEGIN
	INSERT INTO drugs(typeId,drug_name,quantity,unit,drug_price,usage,manuId,manuDay,expireDay,drugStatus)
	VALUES(@typeId,@drug_name,@quantity,@unit,@drug_price,@usage,@manuId,@manuDay,@expireDay,@drugStatus)
END
GO

CREATE PROC deleteDrug
@id INT
AS
BEGIN
	DELETE FROM drugs WHERE id = @id
END
GO

CREATE PROC getManuName
@manuName VARCHAR(50)
AS
BEGIN
	SELECT id FROM manufacturers
	WHERE manu_name = @manuName
END
GO


CREATE PROC checkExpireDay
@alertMonth INT
AS
BEGIN
	SELECT drugs.id,drugs.typeId,drugs.drug_name,drugs.quantity,drugs.unit,drugs.drug_price,drugs.usage,manufacturers.manu_name,drugs.manuDay,drugs.expireDay,drugs.drugStatus
	FROM drugs
	INNER JOIN drugType ON drugs.typeId = drugType.id	
	INNER JOIN manufacturers ON drugs.manuId = manufacturers.id
	WHERE DATEDIFF(MONTH,GETDATE(),expireDay)<= @alertMonth
END
GO

CREATE PROC searchDrug
@drug_name VARCHAR(50)
AS
BEGIN
	SELECT drugs.id, drugs.typeId,drugs.drug_name,drugs.quantity,drugs.unit,drugs.drug_price,drugs.usage,manufacturers.manu_name,drugs.manuDay,drugs.expireDay,drugs.drugStatus
	FROM drugs
	INNER JOIN drugType
	ON drugs.typeId = drugType.id	
	INNER JOIN manufacturers
	ON drugs.manuId = manufacturers.id
	WHERE drug_name = @drug_name
END
GO

CREATE PROC searchType
@typeId VARCHAR(20)
AS
BEGIN 
	SELECT drugs.id, drugs.typeId,drugs.drug_name,drugs.quantity,drugs.unit,drugs.drug_price,drugs.usage,manufacturers.manu_name,drugs.manuDay,drugs.expireDay,drugs.drugStatus
	FROM drugs
	INNER JOIN drugType
	ON drugs.typeId = drugType.id	
	INNER JOIN manufacturers
	ON drugs.manuId = manufacturers.id
	WHERE typeId = @typeId
END
GO

CREATE PROC searchUsage
@usage VARCHAR(20)
AS
BEGIN 
	SELECT drugs.id, drugs.typeId,drugs.drug_name,drugs.quantity,drugs.unit,drugs.drug_price,drugs.usage,manufacturers.manu_name,drugs.manuDay,drugs.expireDay,drugs.drugStatus
	FROM drugs
	INNER JOIN drugType
	ON drugs.typeId = drugType.id	
	INNER JOIN manufacturers
	ON drugs.manuId = manufacturers.id
	WHERE usage = @usage
END
GO

-- drugType function
CREATE PROC countDrugType 
AS
BEGIN
	SELECT COUNT(id) total FROM drugType
END 
GO

CREATE PROC getDrugType
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT * FROM drugType
	ORDER BY id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC  insertDrugType
@id VARCHAR(20),@typeName VARCHAR(50)
AS
BEGIN 
	INSERT INTO drugType(id,typeName)
	VALUES (@id,@typeName)
END
GO

CREATE PROC updateDrugType
@typeName VARCHAR(50),@id VARCHAR(20)
AS
BEGIN
	UPDATE drugType
	SET typeName=@typeName
	WHERE id = @id
END
GO

CREATE PROC searchTypeId
@id VARCHAR(20) 
AS
BEGIN
	SELECT * FROM drugType
	WHERE id =@id
END
GO

CREATE PROC searchTypeName
@typeName VARCHAR(50) 
AS
BEGIN
	SELECT * FROM drugType
	WHERE typeName=@typeName
END
GO

---- Customer function
CREATE PROC countCus 
AS
BEGIN
	SELECT COUNT(id) total FROM customers
END 
GO

CREATE PROC getCus
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT * FROM customers
	ORDER BY id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC insertCus
@cus_name VARCHAR(30),@gender BIT,@cus_phone INT
AS
BEGIN
	insert into customers(cus_name,gender,cus_phone)
	values (@cus_name,@gender,@cus_phone)
END 
GO

CREATE PROC updateCus
@cus_name VARCHAR(30),@gender BIT,@cus_phone INT,@id INT
AS
BEGIN
	UPDATE customers
	SET cus_name =@cus_name, gender = @gender,cus_phone=@cus_phone
	WHERE id = @id
END
GO

CREATE PROC deleteCus
@id INT
AS
BEGIN
	DELETE FROM customers
	WHERE id = @id
END 
GO

CREATE PROC searchCusName
@cus_name VARCHAR(30)
AS
BEGIN
	SELECT*FROM customers
	WHERE cus_name = @cus_name
END
GO

CREATE PROC searchCusPhone
@cus_phone INT
AS
BEGIN
	SELECT*FROM customers
	WHERE cus_phone=@cus_phone
END
GO

----Order function
CREATE PROC countOrder
AS
BEGIN
	SELECT COUNT(id) total FROM orders
END 
GO

CREATE PROC getOrder
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT orders.id,customers.cus_name,payment.payMode,orders.orderDate,
		orders.amountPaid
	FROM orders 
	INNER JOIN customers ON orders.cusId = customers.id
	INNER JOIN payment ON orders.payId = payment.id
	ORDER BY id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC insertOrder
@cus_id INT,
@pay_id INT,
@order_date DATE,
@amountPaid DECIMAL(10,3)
AS
BEGIN
	INSERT INTO orders(cusId,payId,orderDate,amountPaid)
	VALUES(@cus_id,@pay_id,@order_date,@amountPaid)
END
GO

CREATE PROC updateOrder
@cusId INT,
@payId INT,
@orderDate DATE,
@amountPaid DECIMAL(10,3),
@id INT
AS
BEGIN
	UPDATE orders 
	SET cusId=@cusId,payId=@payId,orderDate=@orderDate,
	amountPaid=@amountPaid
	WHERE id=@id
END
GO

CREATE PROC deleteOrder
@id INT
AS
BEGIN
	DELETE FROM orders WHERE id=@id
END
GO

CREATE PROC searchOrderCus
@cus_name VARCHAR(30)
AS
BEGIN
	SELECT orders.id,customers.cus_name,payment.payMode,orders.orderDate,
		orders.amountPaid
	FROM orders 
	INNER JOIN customers ON orders.cusId = customers.id
	INNER JOIN payment ON orders.payId = payment.id
	WHERE cus_name = @cus_name
END
GO

CREATE PROC getCustomerOrder
@customer VARCHAR(30)
AS
BEGIN
	SELECT id FROM customers
	WHERE cus_name = @customer
END
GO

CREATE PROC getPayOrder
@payMode VARCHAR(20)	
AS
BEGIN
	SELECT id FROM payment	
	WHERE payMode = @payMode
END
GO

---- Order Detail function

CREATE PROC countOrderDetail
AS
BEGIN
	SELECT COUNT(id) total FROM orderDetail
END 
GO

CREATE PROC getOrderDetail
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT orderDetail.id,orderDetail.orderId,drugs.drug_name,
	orderDetail.priceEach,orderDetail.quantity
	FROM orderDetail
	INNER JOIN orders ON orderDetail.orderId = orders.id
	INNER JOIN drugs ON orderDetail.drugId = drugs.id
	ORDER BY orderDetail.id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC insertOrderDetail
@order_id INT,
@drug_id INT,
@price_each DECIMAL(10,3),
@quantity INT
AS
BEGIN
	INSERT INTO orderDetail(orderId,drugId,priceEach,quantity)
	VALUES(@order_id,@drug_id,@price_each,@quantity)
END
GO

CREATE PROC updateOrderDetail
@order_id INT,
@drug_id INT,
@price_each DECIMAL(10,3),
@quantity INT,
@id INT
AS
BEGIN
	UPDATE orderDetail
	SET orderId=@order_id,drugId=@drug_id,priceEach=@price_each,
	quantity=@quantity
	WHERE id=@id
END
GO

CREATE PROC deleteOrderDetail
@id INT
AS
BEGIN
	DELETE FROM orderDetail WHERE id=@id
END
GO

CREATE PROC searchOrderId
@order_id INT
AS
BEGIN
	SELECT orderDetail.id,orderDetail.orderId,drugs.drug_name,
	orderDetail.priceEach,orderDetail.quantity
	FROM orderDetail
	INNER JOIN orders ON orderDetail.orderId = orders.id
	INNER JOIN drugs ON orderDetail.drugId = drugs.id
	WHERE orderDetail.orderId = @order_id
END
GO

CREATE PROC getDrugIdDetail
@drugName VARCHAR(50)	
AS
BEGIN
	SELECT id FROM drugs	
	WHERE drug_name = @drugName
END
GO

---- Supplier function
CREATE PROC countManu 
AS
BEGIN
	SELECT COUNT(id) total FROM manufacturers
END 
GO

CREATE PROC getManu
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT * FROM manufacturers
	ORDER BY id
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC insertManu
@manu_name VARCHAR(50),@manu_address VARCHAR(50),@manu_phone INT
AS
BEGIN
	insert into manufacturers(manu_name,manu_address,manu_phone)
	values (@manu_name,@manu_address,@manu_phone)
END 
GO

CREATE PROC updateManu
@manu_name VARCHAR(50),@manu_address VARCHAR(50),@manu_phone INT,@id INT
AS
BEGIN
	UPDATE manufacturers
	SET manu_name =@manu_name, manu_address =@manu_address,manu_phone=@manu_phone
	WHERE id = @id
END
GO

CREATE PROC deleteManu
@id INT
AS
BEGIN
	DELETE FROM manufacturers
	WHERE id = @id
END 
GO

CREATE PROC searchManuName
@manu_name VARCHAR(50)
AS
BEGIN
	SELECT*FROM manufacturers
	WHERE manu_name = @manu_name
END
GO

CREATE PROC searchManuPhone
@manu_phone INT
AS
BEGIN
	SELECT*FROM manufacturers
	WHERE manu_phone=@manu_phone
END
GO

---- Reciept function

CREATE PROC updateQuantityDrug
@drug_id INT,
@quantityUpdate INT
AS
BEGIN 
	UPDATE drugs 
	SET quantity = quantity-@quantityUpdate
	WHERE id=@drug_id
END
GO

CREATE PROC getOrderId
@cusId INT , @payment INT, @orderDate DATE, @amount DECIMAL(10,3)
AS
BEGIN
	SELECT id FROM orders
	WHERE cusId =@cusId AND payId=@payment AND orderDate=@orderDate
	AND amountPaid= @amount
END
GO

CREATE PROC getReceipt
@cusId INT , @orderDate DATE
AS
BEGIN
	SELECT orders.orderDate,drugs.drug_name,
	orderDetail.quantity,drugs.unit,orderDetail.priceEach
	FROM orderDetail
	INNER JOIN orders ON orderDetail.orderId = orders.id
	INNER JOIN drugs ON orderDetail.drugId = drugs.id
	WHERE orders.cusId =@cusId AND orders.orderDate=@orderDate
	ORDER BY orderDetail.id
END
GO

CREATE PROC allAmountReceipt
@cusId INT , @orderDate DATE
AS
BEGIN
	SELECT SUM(amountPaid) totalAmount
	FROM orders
	WHERE cusId = @cusId AND orderDate =@orderDate
END
GO

CREATE PROC checkCusExist
	@cus_name VARCHAR(30),@gender BIT,@phone INT
	AS
	BEGIN
		IF EXISTS (SELECT 1 FROM customers WHERE cus_name = @cus_name)
			BEGIN
				UPDATE customers
				SET cus_name=@cus_name, gender=@gender,cus_phone=@phone
				WHERE cus_name=@cus_name
			END
		ELSE 
			BEGIN
				INSERT INTO customers (cus_name, gender, cus_phone)
				VALUES (@cus_name,@gender,@phone)
			END	
	END
GO

-- Statistic function

CREATE PROC getStatistic
@orderDate DATE
AS
BEGIN
	SELECT orders.orderDate,drugs.drug_name,orderDetail.quantity,
	drugs.unit,orderDetail.priceEach
	FROM orderDetail
	INNER JOIN orders ON orderDetail.orderId = orders.id
	INNER JOIN drugs ON orderDetail.drugId = drugs.id
	WHERE orders.orderDate=@orderDate
	ORDER BY orderDetail.id
END
GO

CREATE PROC allAmountStatistic
@orderDate DATE
AS
BEGIN
	SELECT SUM(amountPaid) totalAmountStatistic FROM orders
	WHERE orderDate=@orderDate
END
GO

CREATE PROC allQuantityStatistic
@orderDate DATE
AS
BEGIN
	SELECT SUM(quantity) totalQuantityStatic FROM orderDetail
	INNER JOIN orders ON orderDetail.orderId = orders.id
	WHERE orders.orderDate=@orderDate
END
GO

-- INSERT DRUGS TYPE
INSERT INTO drugType(id,typeName)
VALUES('AA01','Analgesic and antipyretic'),
('AA02','Analgesic and anti-inflammatory'),
('A01','Antibiotic'),
('AM01','Antidiabetic medication'),
('AM02','Antihypertensive medication'),
('AT01','Antiretroviral therapy'),
('DM01','Diabetes mellitus')
GO

-- INSERT DRUGS

INSERT INTO manufacturers(manu_name,manu_address,manu_phone)
VALUES('GlaxoSmithKline','USA',357456197),
('Bristol Myers Squibb','UK',753695124),
('VarkoKeu Ley','UK',753695124),
('Bayer','UK',753159468),
('Novo Nordisk','Africa',097562877),
('Eli Lilly','Japan',456789123),
('Sanofi','Korea',856789123),
('Merck','USA',856789123),
('AstraZeneca','Russia',156789123),
('Novartis','USA',256889123),
('Boehringer Ingelheim','Brazil',656489123),
('ViiV Healthcare','USA',756489173)
GO

-- INSERT DRUGS

/*INSERT INTO drugs(typeId,drug_name,quantity,unit,drug_price,usage,manuId,manuDay,expireDay,drugStatus)
	VALUES('AA01','Panadol',100,'Tablets',10,'Pain,fever',1,'2022/02/30','2024/02/24',1),
	('AA01','Efferalgan',50,'Tablets',15,'Pain,fever',2,'2024/02/15','2026/02/14',1),
	('AA01','Paracetamol',200,'Tablets',5,'Pain,fever',3,'2024/03/05','2026/03/04',1),
	('AA01','Aspirin',150,'Tablets',2,'De-infla,prev-blood',4,'2024/10/04','2026/09/04',1),
	('AA02','Ibuprofen',80,'Tablets',7,'Pain relief',5,'2024/05/15','2026/05/14', 1),
	('A01','Amoxicillin',60,'Capsules',30,'Bacterial infections',6,'2024/06/20','2026/06/19', 1),
	('A01','Augmentin',40,'Tablets',50,'Bacterial infections',7,'2024/07/25','2026/07/24', 1),
	('A01','Cefixime',30,'Tablets',40,'Bacterial infections',8,'2024/08/30','2026/08/29', 1),
	('A01','Azithromycin',25,'Tablets',25,'Bacterial infections',9,'2022/08/30','2023/12/31', 0),
	('A01','Clarithromycin',20,'Tablets',35,'Bacterial infections',10,'2022/09/10','2023/08/10', 1),
	('AM01','Simvastatin',20,'Tablets',25,'Lower cholesterol',11,'2024/08/30','2026/08/29', 1),
	('AM01','Atorvastatin',15,'Tablets',30,'Lower cholesterol',12,'2024/10/04','2026/09/04', 1),
	('AM01','Rosuvastatin',10,'Tablets',35,'Lower cholesterol',1,'2022/02/26','2024/02/11',0),
	('AM01','Ezetimibe',8,'Tablets',40,'Lower cholesterol',2,'2022/09/10','2023/08/10', 1),
	('AM01','Fenofibrate',6,'Tablets',20,'Lower triglyceride',3,'2024/07/25','2026/07/24', 1),
	('AM01','Metformin',100,'Tablets',12,'Di-2 control sugar',4,'2023/04/11','2026/11/13', 1),
	('AM01','Gliclazide',50,'Tablets',15,'Di-2 control sugar',5,'2024/08/30','2026/08/29', 1),
	('AM01','Insulin',20,'Vials',200,'Regulate sugar',6,'2024/03/05','2026/03/04', 1),
	('AM02','Losartan',40,'Tablets',30,'Heart failure',7,'2021/05/19','2022/09/23', 0),
	('AM02','Atenolol',30,'Tablets',20,'Heart rhythm disord',8,'2024/08/30','2026/08/29', 1),
	('AM02','Amlodipine',25,'Tablets',25,'Chest pain',8,'2024/10/04','2026/09/04', 1),
	('AM02','Ramipril',15,'Tablets',18,'Heart attack',1,'2024/05/14','2026/05/13', 1),
	('DM01','Metformin',50,'Tablets',45,'Di-2 re-glucose',3,'2024/03/05','2026/03/04', 1),
	('DM01','Sitagliptin',40,'Tablets',50,'Di-2 inhibit DPP-4',5,'2021/05/19','2022/09/23', 0),
	('DM01','Saxagliptin',30,'Tablets',60,'Di-2 inhibit DPP-4',9,'2024/03/05','2026/03/04', 1),
	('DM01','Vildagliptin',25,'Tablets',70,'Di-2 inhibit DPP-4',12,'2024/03/05','2026/03/04', 1),
	('DM01','Linagliptin',20,'Tablets',80,'Di-2 inhibit DPP-4',12,'2023/04/11','2026/11/13', 1),
	('AT01','Dolutegravir',15,'Tablets',90,'HIV infection',4,'2023/04/11','2026/11/13', 1),
	('AT01','Efavirenz',10,'Capsules',100,'HIV infection',4,'2024/10/04','2026/09/04', 1),
	('AT01','Tenofovir',8,'Tablets',110,'HIV infection,Bvirus',6,'2024/03/05','2026/03/04', 1),
	('AT01','Lamivudine',6,'Tablets',120,'HIV infection,Bvirus',6,'2024/03/05','2026/03/04', 1),
	('AT01','Nevirapine',5,'Tablets',130,'HIV infection',6,'2024/08/30','2026/08/29', 1)
GO*/
INSERT INTO drugs(typeId, drug_name, quantity, unit, drug_price, usage, manuId, manuDay, expireDay, drugStatus)
VALUES
    ('AA01', 'Panadol', 100, 'Tablets', 10, 'Pain,fever', 1, '2022-02-28', '2024-02-24', 1),
    ('AA01', 'Efferalgan', 50, 'Tablets', 15, 'Pain,fever', 2, '2024-02-15', '2026-02-14', 1),
    ('AA01', 'Paracetamol', 200, 'Tablets', 5, 'Pain,fever', 3, '2024-03-05', '2026-03-04', 1),
    ('AA01', 'Aspirin', 150, 'Tablets', 2, 'De-infla,prev-blood', 4, '2024-10-04', '2026-09-04', 1),
    ('AA02', 'Ibuprofen', 80, 'Tablets', 7, 'Pain relief', 5, '2024-05-15', '2026-05-14', 1),
    ('A01', 'Amoxicillin', 60, 'Capsules', 30, 'Bacterial infections', 6, '2024-06-20', '2026-06-19', 1),
    ('A01', 'Augmentin', 40, 'Tablets', 50, 'Bacterial infections', 7, '2024-07-25', '2026-07-24', 1),
    ('A01', 'Cefixime', 30, 'Tablets', 40, 'Bacterial infections', 8, '2024-08-30', '2026-08-29', 1),
    ('A01', 'Azithromycin', 25, 'Tablets', 25, 'Bacterial infections', 9, '2022-08-30', '2023-12-31', 0),
    ('A01', 'Clarithromycin', 20, 'Tablets', 35, 'Bacterial infections', 10, '2022-09-10', '2023-08-10', 1),
    ('AM01', 'Simvastatin', 20, 'Tablets', 25, 'Lower cholesterol', 11, '2024-08-30', '2026-08-29', 1),
    ('AM01', 'Atorvastatin', 15, 'Tablets', 30, 'Lower cholesterol', 12, '2024-10-04', '2026-09-04', 1),
    ('AM01', 'Rosuvastatin', 10, 'Tablets', 35, 'Lower cholesterol', 1, '2022-02-26', '2024-02-11', 0),
    ('AM01', 'Ezetimibe', 8, 'Tablets', 40, 'Lower cholesterol', 2, '2022-09-10', '2023-08-10', 1),
    ('AM01', 'Fenofibrate', 6, 'Tablets', 20, 'Lower triglyceride', 3, '2024-07-25', '2026-07-24', 1),
    ('AM01', 'Metformin', 100, 'Tablets', 12, 'Di-2 control sugar', 4, '2023-04-11', '2026-11-13', 1),
    ('AM01', 'Gliclazide', 50, 'Tablets', 15, 'Di-2 control sugar', 5, '2024-08-30', '2026-08-29', 1),
    ('AM01', 'Insulin', 20, 'Vials', 200, 'Regulate sugar', 6, '2024-03-05', '2026-03-04', 1),
    ('AM02', 'Losartan', 40, 'Tablets', 30, 'Heart failure', 7, '2021-05-19', '2022-09-23', 0),
    ('AM02', 'Atenolol', 30, 'Tablets', 20, 'Heart rhythm disord', 8, '2024-08-30', '2026-08-29', 1),
    ('AM02', 'Amlodipine', 25, 'Tablets', 25, 'Chest pain', 8, '2024-10-04', '2026-09-04', 1),
    ('AM02', 'Ramipril', 15, 'Tablets', 18, 'Heart attack', 1, '2024-05-14', '2026-05-13', 1),
    ('DM01', 'Metformin', 50, 'Tablets', 45, 'Di-2 re-glucose', 3, '2024-03-05', '2026-03-04', 1),
    ('DM01', 'Sitagliptin', 40, 'Tablets', 50, 'Di-2 inhibit DPP-4', 5, '2021-05-19', '2022-09-23', 0),
    ('DM01', 'Saxagliptin', 30, 'Tablets', 60, 'Di-2 inhibit DPP-4', 9, '2024-03-05', '2026-03-04', 1),
    ('DM01', 'Vildagliptin', 25, 'Tablets', 70, 'Di-2 inhibit DPP-4', 12, '2024-03-05', '2026-03-04', 1),
    ('DM01', 'Linagliptin', 20, 'Tablets', 80, 'Di-2 inhibit DPP-4', 12, '2023-04-11', '2026-11-13', 1),
    ('AT01', 'Dolutegravir', 15, 'Tablets', 90, 'HIV infection', 4, '2023-04-11', '2026-11-13', 1),
    ('AT01', 'Efavirenz', 10, 'Capsules', 100, 'HIV infection', 4, '2024-10-04', '2026-09-04', 1),
    ('AT01', 'Tenofovir', 8, 'Tablets', 110, 'HIV infection,Bvirus', 6, '2024-03-05', '2026-03-04', 1),
    ('AT01', 'Lamivudine', 6, 'Tablets', 120, 'HIV infection,Bvirus', 6, '2024-03-05', '2026-03-04', 1),
    ('AT01', 'Nevirapine', 5, 'Tablets', 130, 'HIV infection', 6, '2024-08-30', '2026-08-29', 1)
	GO
--INSERT PAYMENT
INSERT INTO payment(payMode)
VALUES('Banking'),
('Pay Direct')
GO

--INSERT CUSTOMER

INSERT INTO customers(cus_name,gender,cus_phone)
VALUES ('Nguyen Van A',1,15975346),
('Nguyen Van B',1,35575346),
('Nguyen Thi Van C',0,65995346),
('Nguyen Van D',1,15015346),
('Tran Van A',1,75975316),
('Tran Van B',1,95905346),
('Tran Thi Van C',0,85905216),
('Tran Van D',1,45915316),
('Ly Cong A',0,75975316),
('Ly Cong B',1,15345316),
('Ly Cong C',0,78342316),
('Ly Cong D',0,55375316),
('Huynh Van A',0,89315316),
('Huynh Van B',1,89315123),
('Huynh Van C',1,89315312),
('Huynh Van D',1,89315213)
GO

--INSERT ORDER
INSERT INTO orders(cusId, payId, orderDate, amountPaid)
VALUES (1, 1, '2024/01/18', 300),  
(1, 2, '2024/01/19', 150),
(2, 1, '2024-01-20', 200),
(3, 2, '2024-01-21', 180),
(4, 1, '2024-01-22', 220),  
(5, 2, '2024-01-23', 150),  
(6, 1, '2024-01-24', 300),  
(7, 2, '2024-01-25', 180),  
(8, 1, '2024-01-26', 250),  
(9, 2, '2024-01-27', 200),  
(10, 1, '2024-01-28', 320), 
(11, 2, '2024-01-29', 180), 
(12, 1, '2024-01-30', 270), 
(13, 2, '2024-01-31', 230)
GO

--INSERT ORDER DETAIL
INSERT INTO orderDetail(orderId,drugId,priceEach,quantity)
VALUES(1, 1, 10, 20),
(1, 2, 15, 10),
(1, 3, 5, 40),
(3, 6, 30, 15),   
(3, 7, 50, 8),    
(3, 8, 40, 10),
(4, 9, 25, 20),
(4, 10, 35, 12),
(5, 11, 20, 15),  
(5, 12, 30, 10),  
(5, 13, 35, 8),   
(6, 14, 40, 20), 
(6, 15, 20, 12)
GO