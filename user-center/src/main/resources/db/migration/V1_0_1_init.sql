CREATE TABLE if not exists user_info
(
    id VARCHAR(64) NOT NULL comment '用户ID',
    name VARCHAR(64) NOT NULL comment '用户名',
    pwd VARCHAR(64) NOT NULL comment '密码',
    alias VARCHAR(64) NOT NULL comment '昵称',
    describe VARCHAR(128) NOT NULL comment '描述',
    credit int default 0 NOT NULL comment '积分',
    type VARCHAR(20) NOT NULL comment '类型（金牌/银牌/..）',
    vip tinyint(1) DEFAULT '0'  comment '是否购买vip',
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  comment '注册时间',
    update_at TIMESTAMP NOT NULL comment '更新时间',
    PRIMARY KEY (id),
)
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;