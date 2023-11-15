-- 커리큘럼 5개 생성
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (1, '2023-01-03', '2023-01-03', '전체'),
       (2, '2023-01-03', '2023-01-03', '풀스택'),
       (3, '2023-01-03', '2023-01-03', '정보 보안 과정'),
       (4, '2023-01-03', '2023-01-03', '쿠버네티스 과정'),
       (5, '2023-01-03', '2023-01-03', 'AI자연어처리 과정');

-- 멤버 3개 생성  123456789!
insert into member (account_id, created_at, updated_at, name, password)
values ('hello1', '2023-01-03', '2023-01-03', '홍길동(풀스택 2회차)', '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6'),
    ('hello2', '2023-01-03', '2023-01-03', '아무개(풀스택 2회차)',
     '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6'),
    ('hello3', '2023-01-03', '2023-01-03', '김밥(풀스택 2회차)',
     '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');

-- post 데이터 30개
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title, curriculum_id, member_id)
values (0, 'contactUrl1', 'content1', '2023-01-10', '2023-07-19', 3, 1, 'title1', 1, 1),
       (0, 'contactUrl2', 'content2', '2023-01-10', '2023-07-19', 3, 1, 'title2', 1, 1),
       (0, 'contactUrl3', 'content3', '2023-01-10', '2023-07-19', 3, 1, 'Title3', 1, 1),
       (0, 'contactUrl4', 'content4', '2023-01-10', '2023-07-19', 4, 1, 'title4', 1, 1),
       (0, 'contactUrl5', 'content5', '2023-01-10', '2023-07-19', 4, 1, 'Title5', 1, 1),
       (0, 'contactUrl6', 'content6', '2023-01-10', '2023-07-19', 4, 1, 'Title6', 2, 1),
       (0, 'contactUrl7', 'content7', '2023-01-10', '2023-07-19', 3, 1, 'title7', 2, 1),
       (0, 'contactUrl8', 'content8', '2023-01-10', '2023-07-19', 3, 1, 'Title8', 2, 1),
       (0, 'contactUrl9', 'content9', '2023-01-10', '2023-07-19', 4, 1, 'title9', 2, 1),
       (0, 'contactUrl10', 'content10', '2023-01-10', '2023-07-19', 4, 0, 'Title10', 2, 1),
       (0, 'contactUrl11', 'content11', '2023-01-10', '2023-07-19', 4, 1, 'Title11', 2, 1),
       (0, 'contactUrl12', 'content12', '2023-01-10', '2023-07-19', 3, 1, 'title12', 2, 1),
       (0, 'contactUrl13', 'content13', '2023-01-10', '2023-07-19', 3, 1, 'title13', 2, 1),
       (0, 'contactUrl14', 'content14', '2023-01-10', '2023-07-19', 3, 1, 'Title14', 2, 1),
       (0, 'contactUrl15', 'content15', '2023-01-10', '2023-07-19', 4, 1, 'title15', 2, 1),
       (0, 'contactUrl16', 'content16', '2023-01-10', '2023-07-19', 4, 1, 'Title16', 2, 2),
       (0, 'contactUrl17', 'content17', '2023-01-10', '2023-07-19', 4, 1, 'Title17', 2, 2),
       (0, 'contactUrl18', 'content8', '2023-01-10', '2023-07-19', 4, 1, 'Title18', 2, 2),
       (0, 'contactUrl19', 'content19', '2023-01-10', '2023-07-19', 4, 1, 'Title19', 2, 2),
       (0, 'contactUrl20', 'content20', '2023-01-10', '2023-07-19', 4, 0, 'Title20', 2, 2),
       (0, 'contactUrl21', 'content21', '2023-01-10', '2023-07-19', 4, 1, 'Title21', 2, 2),
       (0, 'contactUrl22', 'content22', '2023-01-10', '2023-07-19', 4, 1, 'Title22', 2, 2),
       (0, 'contactUrl23', 'content23', '2023-01-10', '2023-07-19', 4, 1, 'Title23', 2, 2),
       (0, 'contactUrl24', 'content24', '2023-01-10', '2023-07-19', 4, 1, 'Title24', 2, 2),
       (0, 'contactUrl25', 'content25', '2023-01-10', '2023-07-19', 4, 1, 'Title25', 2, 2),
       (0, 'contactUrl26', 'content26', '2023-01-10', '2023-07-19', 4, 1, 'Title26', 2, 2),
       (0, 'contactUrl27', 'content27', '2023-01-10', '2023-07-19', 4, 1, 'Title27', 2, 2),
       (0, 'contactUrl28', 'content28', '2023-01-10', '2023-07-19', 4, 1, 'Title28', 5, 2),
       (0, 'contactUrl29', 'content29', '2023-01-10', '2023-07-19', 4, 1, 'Title29', 5, 2),
       (0, 'contactUrl30', 'content30', '2023-01-10', '2023-07-19', 4, 0, 'Title30', 5, 2);

-- post_subject
insert into post_subject (post_id, subjects)
values (1, 'INTERVIEW'), (1, 'FRONTEND'), (1, 'DEVOPS'),
       (2, 'CS'), (2, 'CODING_TEST'),
       (3, 'BACKEND'), (3, 'DEVOPS'), (3, 'CS'),
       (4, 'CS'), (4, 'CODING_TEST'), (4, 'FRONTEND'),
       (5, 'INTERVIEW'), (5, 'FRONTEND'), (5, 'DEVOPS'),
       (6, 'CS'), (6, 'CODING_TEST'),
       (7, 'BACKEND'), (7, 'DEVOPS'), (7, 'CS'),
       (8, 'CS'), (8, 'CODING_TEST'), (8, 'FRONTEND'),
       (9, 'CS'), (9, 'CODING_TEST'),
       (10, 'BACKEND'), (10, 'DEVOPS'), (10, 'CS'),
       (11, 'CS'), (11, 'CODING_TEST'), (11, 'FRONTEND'),
       (12, 'INTERVIEW'), (12, 'FRONTEND'), (12, 'DEVOPS'),
       (13, 'CS'), (13, 'CODING_TEST'),
       (14, 'BACKEND'), (14, 'DEVOPS'), (14, 'CS'),
       (15, 'CS'), (15, 'CODING_TEST'), (15, 'FRONTEND'),
       (16, 'CS'), (16, 'CODING_TEST'),
       (17, 'BACKEND'), (17, 'DEVOPS'), (17, 'CS'),
       (18, 'CS'), (18, 'CODING_TEST'), (18, 'FRONTEND'),
       (19, 'INTERVIEW'), (19, 'FRONTEND'), (19, 'DEVOPS'),
       (20, 'CS'), (20, 'CODING_TEST'),
       (21, 'BACKEND'), (21, 'DEVOPS'), (21, 'CS'),
       (22, 'CS'), (22, 'CODING_TEST'), (22, 'FRONTEND'),
       (23, 'CS'), (23, 'CODING_TEST'),
       (24, 'BACKEND'), (24, 'DEVOPS'), (24, 'CS'),
       (25, 'CS'), (25, 'CODING_TEST'), (25, 'FRONTEND'),
       (26, 'CS'), (26, 'CODING_TEST'),
       (27, 'BACKEND'), (27, 'DEVOPS'), (27, 'CS'),
       (28, 'CS'), (28, 'CODING_TEST'), (28, 'FRONTEND'),
       (29, 'INTERVIEW'), (29, 'FRONTEND'), (29, 'DEVOPS'),
       (30, 'CS'), (30, 'CODING_TEST');

-- post_stack
insert into post_stack (post_id, stacks)
values (1, 'JAVA'),
       (1, 'SPRING'),
       (2, 'JAVASCRIPT'),
       (2, 'REACT'),
       (2, 'REDUX'),
       (3, 'AWS'),
       (3, 'KUBERNETES'),
       (4, 'AWS'),
       (4, 'KUBERNETES');

