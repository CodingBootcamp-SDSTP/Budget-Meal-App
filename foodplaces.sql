DROP TABLE IF EXISTS persons_tbl;
CREATE TABLE persons_tbl (
	userid INT PRIMARY KEY AUTOINCREMENT, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL, age INTEGER NOT NULL, location VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, favoritefood VARCHAR(255), establishmentname VARCHAR(255), persontype VARCHAR(255) NOT NULL
);
DROP TABLE IF EXISTS foodplaces_tbl;
CREATE TABLE foodplaces_tbl (
	fpid INT PRIMARY KEY AUTOINCREMENT, fpname VARCHAR(255) NOT NULL, fpaddress VARCHAR(255) NOT NULL, fpmenuname VARCHAR(255) NOT NULL, fpmenuprice INTEGER NOT NULL, fprating INTEGER NOT NULL, fpreview VARCHAR(255), FOREIGN KEY (fpreview) REFERENCES reviews_tbl(reviewid)
);
DROP TABLE IF EXISTS reviews_tbl;
CREATE TABLE reviews_tbl (
	reviewid INT PRIMARY KEY AUTOINCREMENT, reviewtext VARCHAR(255) NOT NULL, reviewrating INTEGER NOT NULL,  reviewerid INTEGER NOT NULL, FOREIGN KEY (reviewerid) REFERENCES persons_tbl(userid)
);
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, favoritefood, persontype) VALUES ('Ivan', 'Nebab', 27, 'Balibago', 'ivannebab@dicttraining.com.ph', 'ivzivzivz', '123456', 'grilled pork bbq', 'foodie' );
INSERT INTO persons_tbl (firstname, lastname, age, location, email, username, password, establishmentname, persontype) VALUES ('John Carl James', 'Nebab', 28, 'Balibago', 'jcjnebab@dicttraining.com.ph', 'nhoooj', '654321', 'Lugaw Queen', 'manager' );
INSERT INTO foodplaces_tbl (fpname, fpaddress, fpmenuname, fpmenuprice, fprating, fpreview) VALUES ('Lugaw Queen', 'Balibago', 'grilled pork bbq', 65.00, 3, 'One of the best grilled pork in Sta Rosa');
INSERT INTO reviews_tbl (reviewtext, reviewrating, reviewerid) VALUES ('One of the best grilled pork in Sta Rosa', 3, 1);