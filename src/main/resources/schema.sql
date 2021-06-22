drop table if exists messages;

create table messages (
    id serial primary key ,
    msg text
);

insert into messages (msg) values
                                  ('any first message'),
                                  ('messages.public> insert into messages (msg) values'),
                                  ('completed in 18 ms'),
                                  ('4 rows affected in 3 ms'),
                                  ('Shutting down ExecutorService ''applicationTaskExecutor'''),
                                  ('o.s.s.concurrent.ThreadPoolTaskExecutor');