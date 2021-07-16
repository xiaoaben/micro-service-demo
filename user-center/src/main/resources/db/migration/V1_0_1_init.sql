CREATE TABLE if not exists user_info
(
    id VARCHAR(64) NOT NULL comment '�û�ID',
    name VARCHAR(64) NOT NULL comment '�û���',
    pwd VARCHAR(64) NOT NULL comment '����',
    alias VARCHAR(64) NOT NULL comment '�ǳ�',
    describe VARCHAR(128) NOT NULL comment '����',
    credit int default 0 NOT NULL comment '����',
    type VARCHAR(20) NOT NULL comment '���ͣ�����/����/..��',
    vip tinyint(1) DEFAULT '0'  comment '�Ƿ���vip',
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  comment 'ע��ʱ��',
    update_at TIMESTAMP NOT NULL comment '����ʱ��',
    PRIMARY KEY (id),
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;