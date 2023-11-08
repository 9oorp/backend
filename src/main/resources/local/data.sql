-- 커리큘럼 5개 생성
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (1, '2023-01-03', '2023-01-03', '전체');
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (2, '2023-01-03', '2023-01-03', '풀스택');
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (3, '2023-01-03', '2023-01-03', '정보 보안 과정');
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (4, '2023-01-03', '2023-01-03', '쿠버네티스 과정');
insert into curriculum (curriculum_id, created_at, updated_at, name)
values (5, '2023-01-03', '2023-01-03', 'AI자연어처리 과정');

-- 멤버 3개 생성  123456789!
insert into member (account_id, created_at, updated_at, name, password)
values ('hello1', '2023-01-03', '2023-01-03', '홍길동(풀스택 2회차)',
        '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');
insert into member (account_id, created_at, updated_at, name, password)
values ('hello2', '2023-01-03', '2023-01-03', '아무개(풀스택 2회차)',
        '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');
insert into member (account_id, created_at, updated_at, name, password)
values ('hello3', '2023-01-03', '2023-01-03', '김밥(풀스택 2회차)',
        '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');

-- post 데이터 30개
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://storify.com',
        'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.',
        '2023-01-10', '2023-07-19', 2, 1, 'House at the End of the Street', 1, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://zimbio.com',
        'Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.',
        '2022-06-12', '2023-07-11', 4, 0, 'Hurricane, The', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://netlog.com',
        'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.',
        '2023-05-12', '2023-04-21', 6, 1, 'Milwaukee, Minnesota', 5, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://omniture.com',
        'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', '2023-03-29',
        '2023-02-13', 10, 0, 'Brink''s Job, The', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://ft.com',
        'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.',
        '2022-10-02', '2023-03-12', 9, 1, 'Volver', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://youku.com',
        'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.',
        '2021-09-23', '2023-02-10', 9, 0, 'Cherrybomb', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://nydailynews.com',
        'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.',
        '2023-01-12', '2022-12-07', 9, 0, 'Return to Me', 1, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://toplist.cz',
        'Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.',
        '2023-02-12', '2022-10-08', 2, 0, 'Head Over Heels (De Pernas pro Ar)', 2, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://drupal.org',
        'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.',
        '2023-02-04', '2023-06-12', 7, 1, 'Shirley Valentine', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://so-net.ne.jp',
        'Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.',
        '2021-10-31', '2023-04-28', 4, 0, 'Randy and the Mob', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://wordpress.org',
        'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat.',
        '2022-10-03', '2023-03-07', 8, 0, 'Million Dollar Legs', 5, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://plala.or.jp',
        'Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.',
        '2022-10-15', '2022-10-25', 5, 0, 'Castles in the Sky', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://yellowpages.com', 'Morbi quis tortor id nulla ultrices aliquet.', '2021-12-19', '2023-06-02', 8, 1,
        'Kid Millions', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://marketwatch.com',
        'Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.',
        '2022-11-20', '2023-05-08', 5, 1, 'Immensee', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://godaddy.com',
        'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.',
        '2022-07-06', '2023-04-22', 5, 1, 'Love Meetings (Comizi d''amore)', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://alibaba.com',
        'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.',
        '2022-08-12', '2023-04-24', 7, 0, 'Same Old Song (On connaît la chanson)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://cdc.gov',
        'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.',
        '2023-06-17', '2022-11-21', 1, 0, 'Ms. 45 (a.k.a. Angel of Vengeance)', 1, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://123-reg.co.uk',
        'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.',
        '2023-07-14', '2023-01-14', 4, 0, 'Mustasukkaisuus', 2, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://tuttocitta.it',
        'Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.',
        '2022-10-24', '2023-08-05', 2, 0, 'Source Code', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://fastcompany.com',
        'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.',
        '2022-08-16', '2022-12-11', 1, 1, 'Uprising', 5, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://ibm.com',
        'Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.',
        '2022-03-20', '2022-11-25', 10, 1, 'Heart of a Dog (Sobachye serdtse)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://dailymail.co.uk',
        'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.',
        '2021-10-20', '2023-01-24', 5, 1, 'House on Carroll Street, The', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://last.fm',
        'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.',
        '2023-04-07', '2023-07-15', 6, 0, 'Bonjour Monsieur Shlomi (Ha-Kochavim Shel Shlomi)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://histats.com',
        'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.',
        '2023-06-10', '2023-09-10', 8, 0, 'The Power and the Glory', 1, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://google.pl', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', '2023-02-19', '2023-05-22',
        5, 0, 'Lady and the Duke, The (Anglaise et le duc, L'')', 3, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://sfgate.com', 'Proin interdum mauris non ligula pellentesque ultrices.', '2023-06-09', '2022-10-26',
        9, 0, 'Win Win', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://ed.gov',
        'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.',
        '2022-04-10', '2022-10-27', 9, 0, 'Light It Up', 1, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://disqus.com',
        'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.',
        '2023-06-02', '2023-03-05', 3, 1, 'Man of the East', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://bigcartel.com', 'In blandit ultrices enim.', '2023-08-07', '2022-12-21', 3, 0,
        'Shadow of Angels (Schatten der Engel)', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://seesaa.net',
        'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.',
        '2023-06-01', '2023-09-01', 6, 1, 'Last Horror Movie, The', 3, 1);

-- post_subject

insert into post_subject (post_id, subjects)
values (1, 'INTERVIEW'),
       (1, 'FRONTEND'),
       (1, 'DEVOPS'),
       (2, 'CS'),
       (2, 'CODING_TEST'),
       (2, 'FRONTEND'),
       (3, 'BACKEND'),
       (3, 'DEVOPS'),
       (3, 'CS'),
       (4, 'CS'),
       (4, 'CODING_TEST'),
       (4, 'FRONTEND'),
       (5, 'DEVOPS'),
       (5, 'CS'),
       (6, 'DEVOPS'),
       (6, 'CS'),
       (6, 'CODING_TEST'),
       (7, 'CODING_TEST'),
       (7, 'FRONTEND'),
       (8, 'BACKEND'),
       (9, 'FRONTEND'),
       (9, 'BACKEND'),
       (10, 'FRONTEND'),
       (10, 'BACKEND'),
       (11, 'DEVOPS'),
       (11, 'CS'),
       (12, 'CS'),
       (13, 'CODING_TEST'),
       (14, 'CODING_TEST'),
       (15, 'CS'),
       (16, 'BACKEND'),
       (16, 'DEVOPS'),
       (17, 'BACKEND'),
       (17, 'DEVOPS'),
       (18, 'INTERVIEW'),
       (18, 'FRONTEND'),
       (19, 'INTERVIEW'),
       (19, 'FRONTEND'),
       (20, 'DEVOPS'),
       (20, 'CS'),
       (21, 'DEVOPS'),
       (21, 'CS'),
       (22, 'BACKEND'),
       (23, 'BACKEND'),
       (24, 'BACKEND'),
       (24, 'DEVOPS'),
       (25, 'CODING_TEST'),
       (26, 'CODING_TEST'),
       (27, 'INTERVIEW'),
       (27, 'BACKEND'),
       (28, 'CODING_TEST'),
       (28, 'INTERVIEW'),
       (29, 'CODING_TEST'),
       (29, 'INTERVIEW'),
       (30, 'CODING_TEST'),
       (30, 'INTERVIEW');


-- post_stack
insert into post_stack (post_id, stacks) values
    (1, 'JAVA'),
    (1, 'SPRING'),
    (2, 'JAVASCRIPT'),
    (2, 'REACT'),
    (2, 'REDUX'),
    (3, 'AWS'),
    (3, 'KUBERNETES'),
    (4, 'AWS'),
    (4, 'KUBERNETES'),
    (5, 'REACT'),
    (5, 'REDUX'),
    (5, 'AWS'),
    (6, 'REACT'),
    (6, 'REDUX'),
    (7, 'KUBERNETES'),
    (8, 'JAVASCRIPT'),
    (9, 'JAVASCRIPT'),
    (9, 'REACT'),
    (9, 'REDUX'),
    (10, 'JAVASCRIPT'),
    (10, 'REACT'),
    (10, 'REDUX'),
    (11, 'JAVA'),
    (11, 'SPRING'),
    (12, 'JAVA'),
    (12, 'SPRING'),
    (13, 'JAVA'),
    (14, 'SPRING'),
    (15, 'REACT'),
    (16, 'TYPESCRIPT'),
    (16, 'REACT'),
    (16, 'REDUX'),
    (17, 'JAVA'),
    (17, 'SPRING'),
    (18, 'KUBERNETES'),
    (19, 'JAVA'),
    (19, 'SPRING'),
    (20, 'JAVA'),
    (20, 'SPRING'),
    (21, 'TYPESCRIPT'),
    (21, 'REACT'),
    (21, 'REDUX'),
    (22, 'AWS'),
    (22, 'KUBERNETES'),
    (23, 'AWS'),
    (24, 'REACT'),
    (25, 'AWS'),
    (25, 'REACT'),
    (26, 'KUBERNETES'),
    (27, 'JAVA'),
    (27, 'SPRING'),
    (28, 'JAVA'),
    (28, 'SPRING'),
    (29, 'SPRING'),
    (30, 'TYPESCRIPT');
