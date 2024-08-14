-- sm.sys_user definition

CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '用户名',
                            `nick_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '用户昵称',
                            `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL COMMENT '用户密码',
                            `user_type` int DEFAULT NULL COMMENT '用户类型：数据字典sys_user_type',
                            `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL COMMENT '电话号码',
                            `mail` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL COMMENT '邮箱地址',
                            `sex` int DEFAULT NULL COMMENT '性别: 数据字典sys_user_sex',
                            `enabled` int DEFAULT NULL COMMENT '账号是否启用：数据字典sys_user_enabled',
                            `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL COMMENT '头像地址',
                            `account_non_expired` int DEFAULT NULL COMMENT '账号是否过期：数据字典sys_true_false',
                            `credentials_non_expired` int DEFAULT NULL COMMENT '用户凭证是否过期：数据字典sys_true_false',
                            `account_non_locked` int DEFAULT NULL COMMENT '账号是否锁定：数据字典sys_true_false',
                            `create_user_id` bigint DEFAULT NULL COMMENT '创建用户id',
                            `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `last_mod_user` bigint DEFAULT NULL COMMENT '最后修改用户id',
                            `last_mod_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                            `del_flag` int DEFAULT '0' COMMENT '删除标记',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `unique_sys_user` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO sys_user
(id, username, nick_name, password, user_type, phone, mail, sex, enabled, avatar, account_non_expired, credentials_non_expired, account_non_locked, create_user_id, create_time, last_mod_user, last_mod_time, del_flag)
VALUES(1, 'admin', '超级管理员', '$2a$10$5mke.oGWUoqt2gOp0WO7wORbvnWiuLVA5EdA8Qg/0VUEICnx8tnZi', 0, NULL, NULL, 0, 1, 'https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0228%2F4f1943e4j00s9jq7s003ed200sg00sgg005g005g.jpg&thumbnail=660x2147483647&quality=80&type=jpg', 1, 1, 1, 1, now(), NULL, NULL, 0);