CREATE TABLE t_intf_mock_data (
  id NUMBER(18)  NOT NULL  ,
  intf_code varchar(50) DEFAULT NULL ,
  tran_id varchar(20) DEFAULT NULL ,
  type NUMBER(1) DEFAULT NULL ,
  resp_data clob
);

COMMENT on column t_intf_mock_data.id is '无意义主键,取序列seq_intf_mock_data';
COMMENT on column t_intf_mock_data.intf_code is '接口编码';
COMMENT on column t_intf_mock_data.tran_id is '业务流水号,让一个接口可以配置多个模拟报文';
COMMENT on column t_intf_mock_data.type is '1表示json,2表示xml';
COMMENT on column t_intf_mock_data.resp_data is '接口响应报文';

create sequence seq_intf_mock_data
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-复制一条配置
insert into t_intf_mock_data(id,intf_code,type,resp_data) select seq_intf_mock_data.nextval,intf_code,type,resp_data from t_intf_mock_data where intf_code=?;