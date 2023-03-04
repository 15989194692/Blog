create table user (
    `id` bigint AUTO_INCREMENT,
    `user_id` varchar(64) not null,
    `user_name` varchar(256) not null,
    `salt` varchar(256) not null,
    `password` varchar(256) not null,
    `gmt_create` datetime not null,
    `gmt_modified` datetime not null,

    PRIMARY KEY ( `id` ),
    UNIQUE INDEX uk_user_id(`user_id`)

    );


CREATE TABLE `sequence` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建 时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` varchar(64) NOT NULL COMMENT '名称',
  `value` bigint(20) NOT NULL COMMENT '值',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name_tnt` (`name`)
);


create table `blog` (
    `id` bigint(20) unsigned not null AUTO_INCREMENT,
    `gmt_create` datetime not null,
    `gmt_modified` datetime not null,
    `blog_id` varchar(64) not null,
    `user_id` varchar(64) not null,
    `blog_title` varchar(256) not null,
    `blog_content` text,
    `status` varchar(32) not null,

    PRIMARY  KEY (`id`),
    UNIQUE INDEX uk_blog_id(`blog_id`)

);


create table `comment` (
    `id` bigint(20) unsigned not null AUTO_INCREMENT,
    `gmt_create` datetime not null,
    `gmt_modified` datetime not null,
    `comment_id` varchar(64) not null,
    `blog_id` varchar(64) not null,
    `user_id` varchar(64) not null,
    `parent_comment_id` varchar(64) default null,
    `status` varchar(32) not null,
    `comment_content` text default null,

    PRIMARY  KEY (`id`),
    UNIQUE INDEX uk_blog_id(`comment_id`)
)