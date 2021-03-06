CREATE TABLE IF NOT EXISTS DAILY_DATA  (
	NO BIGINT,
	STATION VARCHAR(1000),
	USE_NUM BIGINT
);
CREATE TABLE IF NOT EXISTS MONTHLY_DATA  (
	LINE VARCHAR(100),
	NO BIGINT,
	STATION VARCHAR(1000),
	JAN BIGINT,
	FEB BIGINT,
	MAR BIGINT,
	APR BIGINT,
	MAY BIGINT,
	JUN BIGINT,
	JUL BIGINT,
	AUG BIGINT,
	SEP BIGINT,
	OCT BIGINT,
	NOV BIGINT,
	DEC BIGINT
);
CREATE TABLE IF NOT EXISTS ACCOUNT  (
	USERNAME VARCHAR(100),
	PASSWORD VARCHAR(100)
);