DROP TABLE IF EXISTS persons_tbl;
CREATE TABLE persons_tbl (
	userid INT PRIMARY KEY AUTO_INCREMENT, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, age INTEGER NOT NULL, location VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, favoritefood VARCHAR(255), establishmentname VARCHAR(255), persontype CHAR(20) NOT NULL
);
DROP TABLE IF EXISTS foodplaces_tbl;
CREATE TABLE foodplaces_tbl (
	fpid INT PRIMARY KEY AUTO_INCREMENT, fpname VARCHAR(255) NOT NULL, fplocation VARCHAR(255) NOT NULL, fpmenuname VARCHAR(255) NOT NULL, fpmenuprice DECIMAL(4, 2) NOT NULL
);
DROP TABLE IF EXISTS reviews_tbl;
CREATE TABLE reviews_tbl (
	reviewid INT PRIMARY KEY AUTO_INCREMENT, reviewtext VARCHAR(255) NOT NULL, reviewrating INT NOT NULL,  reviewerid INT NOT NULL, FOREIGN KEY (reviewerid) REFERENCES persons_tbl(userid), foodplaceid INT NOT NULL, FOREIGN KEY (foodplaceid) REFERENCES foodplaces_tbl(fpid), reviewdate DATETIME
);
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, favoritefood, persontype) VALUES ('Ivan', 'Nebab', 27, 'Balibago', 'ivannebab@dicttraining.com.ph', 'ivzivzivz', '123456', 'grilled pork bbq', 'foodie' );
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, favoritefood, persontype) VALUES ('Lemuel', 'Hapa', 20, 'Sta Rosa', 'hapastreet@dicttraining.com.ph', 'hapastreet', '541213', 'chicken wings', 'foodie' );
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, establishmentname, persontype) VALUES ('John Carl James', 'Nebab', 28, 'Balibago', 'jcjnebab@dicttraining.com.ph', 'nhoooj', '654321', 'Lugaw Queen', 'manager' );
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, establishmentname, persontype) VALUES ('Ronald', 'Raz', 33, 'Balibago', 'raz_nald@dicttraining.com.ph', 'ronald_pogi', 'qwerty', 'Overflowings', 'manager' );
INSERT INTO foodplaces_tbl (fpname, fplocation, fpmenuname, fpmenuprice) VALUES ('Lugaw Queen', 'Balibago', 'grilled pork bbq', 65.00);
INSERT INTO foodplaces_tbl (fpname, fplocation, fpmenuname, fpmenuprice) VALUES ('Overflowings', 'Balibago', 'fried chicken wings', 99.00);
INSERT INTO reviews_tbl (reviewtext, reviewrating, reviewerid, foodplaceid, reviewdate ) VALUES ('One of the best grilled pork in Sta Rosa', 3, 1, 1, NOW());
INSERT INTO reviews_tbl (reviewtext, reviewrating, reviewerid, foodplaceid, reviewdate ) VALUES ('Nakakabiting ang sarap', 4, 2, 2, NOW());
