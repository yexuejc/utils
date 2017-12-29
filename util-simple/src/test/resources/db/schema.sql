CREATE TABLE tb_user (
  id varchar(32) NOT NULL,
  mobile varchar(11),
  pwd varchar(32),
  alias varchar(50),
  head varchar(255),
  intro varchar(255),
  crt_time timestamp,
  crt_by varchar(32),
  mdfy_time timestamp,
  mdfy_by varchar(32),
  CONSTRAINT banner_pkey PRIMARY KEY (id)
)
;