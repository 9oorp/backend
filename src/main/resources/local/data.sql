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
        '2023-01-10', '2023-07-19', 2, 1, 'House at the End of the Street', 2, 1);
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
        '2023-01-12', '2022-12-07', 9, 0, 'Return to Me', 2, 1);
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
        '2023-06-17', '2022-11-21', 1, 0, 'Ms. 45 (a.k.a. Angel of Vengeance)', 2, 1);
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
        '2023-06-10', '2023-09-10', 8, 0, 'The Power and the Glory', 2, 2);
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
        '2022-04-10', '2022-10-27', 9, 0, 'Light It Up', 2, 2);
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
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://gov.uk',
        'Curabitur in libero ut massa volutpat convallis.', '2023-09-07', '2023-07-24', 7, 1, 'Carpool', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://newyorker.com',
        'In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.',
        '2022-03-11', '2023-03-24', 5, 1, 'Rising Sun', 3, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://unicef.org',
        'Morbi non quam nec dui luctus rutrum. Nulla tellus.',
        '2022-08-07', '2023-01-13', 9, 1, 'Freedomfighters (Libertarias)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://opensource.org',
        'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.',
        '2022-02-28', '2022-10-03', 4, 1, 'Black Peter (Cerný Petr)', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://hibu.com',
        'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.',
        '2023-08-19', '2023-02-07', 9, 1, 'Time for Drunken Horses, A (Zamani barayé masti asbha)', 4, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://linkedin.com',
        'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui.',
        '2023-07-14', '2023-04-02', 2, 0, 'War of the Roses, The', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://yelp.com',
        'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis.',
        '2022-11-18', '2022-12-11', 10, 1, 'Being Cyrus', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://slashdot.org',
        'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        '2023-01-19', '2023-03-24', 10, 1, 'Magic of Méliès, The (magie Méliès, La)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://shareasale.com',
        'Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.',
        '2023-09-03', '2023-05-23', 10, 1, 'Bronx Tale, A', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://t.co',
        'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.',
        '2022-11-06', '2022-11-30', 9, 0, 'Toll of the Sea, The', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://i2i.jp',
        'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.', '2022-10-24', '2023-07-04', 9, 0, 'Cowboy Way, The', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://hao123.com',
        'Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.',
        '2022-02-07', '2022-11-14', 4, 1, 'Nathalie...', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://earthlink.net',
        'Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.',
        '2023-07-28', '2022-12-05', 3, 0, 'Mary and Max', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://yellowpages.com',
        'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '2021-11-14',
        '2022-12-31', 1, 0, 'Misadventures of Margaret, The', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://newyorker.com',
        'Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.',
        '2023-01-17', '2022-12-13', 3, 1, 'God Is the Bigger Elvis', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://rambler.ru',
        'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui.',
        '2023-09-01', '2023-01-01', 1, 0, 'Housewarming (Travaux, on sait quand ça commence...)', 4, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://acquirethisname.com',
        'Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.',
        '2022-03-06', '2023-04-26', 10, 1, 'Delta of Venus', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://shop-pro.jp',
        'Nullam varius.', '2022-02-18', '2022-11-21', 9, 1, 'Joy of Sex', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://bloomberg.com',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.',
        '2023-07-29', '2023-05-18', 6, 0, 'Hoffa', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://sun.com',
        'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.',
        '2023-07-27', '2023-07-13', 2, 1, 'Leila', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://alibaba.com',
        'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2023-01-14', '2022-11-15', 8, 0, 'Poseidon', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://salon.com',
        'Duis at velit eu est congue elementum.', '2023-08-07', '2023-06-05', 8, 1, 'The Vexxer', 2, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://foxnews.com',
        'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.',
        '2023-03-18', '2023-04-14', 5, 0, 'Object of Beauty, The', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://vinaora.com',
        'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.',
        '2021-07-07', '2022-12-10', 8, 0, 'Night of the Iguana, The', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://merriam-webster.com',
        'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus.', '2022-05-21', '2022-11-29', 9, 0, 'Passion of Anna, The (Passion, En)', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://rakuten.co.jp',
         'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.',
        '2022-07-26', '2023-09-08', 1, 1, 'A Magnificent Haunting', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://google.co.uk',
         'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.',
        '2021-09-14', '2023-02-01', 9, 0, 'Concrete Night (Betoniyö)', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://themeforest.net',
        'Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.',
        '2021-08-29', '2023-06-25', 8, 0, 'Panic Room', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://phpbb.com',
        'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus.', '2021-06-13', '2022-11-14', 9, 1, 'Reggie Watts: Why Shit So Crazy?', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://nationalgeographic.com',
        'Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.',
        '2023-04-07', '2022-12-23', 10, 0, 'Address Unknown (Suchwiin bulmyeong)', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://nature.com',
        'Sed vel enim sit amet nunc viverra dapibus.', '2022-10-22', '2023-04-22', 4, 1, 'Gathering, The', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://china.com.cn',
     'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.',
        '2022-03-11', '2022-12-08', 8, 1, 'Marine, The', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://reuters.com',
        'Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla.',
        '2023-07-04', '2022-10-06', 3, 1, 'Zombie High', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://huffingtonpost.com',
        'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.',
        '2022-02-27', '2023-01-23', 7, 0, 'Alexandra (Aleksandra)', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://posterous.com',
        'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.',
        '2022-08-12', '2023-08-22', 8, 0, 'Z Channel: A Magnificent Obsession', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://theglobeandmail.com',
        'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl.',
        '2023-01-23', '2023-01-02', 6, 0, 'Australia', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://seesaa.net',
        'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',
        '2023-01-08', '2023-02-26', 1, 0, 'Brushfires', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://columbia.edu',
        'Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', '2022-06-07', '2023-02-07', 5, 0, 'Happythankyoumoreplease', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://arstechnica.com',
        'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        '2021-10-04', '2023-05-13', 2, 1, 'My Gun is Quick', 3, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://theguardian.com',
        'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.',
        '2021-08-17', '2022-09-18', 6, 0, 'All Good Things', 4, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://studiopress.com',
        'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        '2022-04-17', '2022-10-19', 2, 0, '3rd Voice, The', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://state.gov',
        'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2021-08-09', '2022-11-02', 5, 0, 'Confidence Girl', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://columbia.edu',
        'Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.',
        '2022-09-24', '2022-10-28', 7, 1, 'City by the Sea', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://auda.org.au',
         'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.',
        '2021-12-14', '2023-06-19', 2, 1, 'Jimmy Carter Man from Plains', 3, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://rakuten.co.jp',
         'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.',
        '2023-09-13', '2023-08-13', 7, 0, '1984 (Nineteen Eighty-Four)', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://dailymail.co.uk',
         'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis.',
        '2022-02-08', '2023-08-14', 9, 0, 'FDR: American Badass!', 5, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://zdnet.com',
        'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.',
        '2021-12-13', '2023-07-05', 1, 0, 'Roger & Me', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://irs.gov',
        'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.',
        '2022-06-01', '2023-01-31', 1, 1, 'Trigun: Badlands Rumble', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://umich.edu',
        'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst.',
        '2021-08-07', '2022-11-10', 7, 0, 'Doomsday Prophecy', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://blinklist.com',
        'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.',
        '2021-06-27', '2022-10-11', 5, 0, 'I Could Never Be Your Woman', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://friendfeed.com',
        'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.',
        '2022-06-01', '2023-04-21', 4, 0, 'Phone (Pon)', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://hp.com',
        'Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis.',
        '2022-07-16', '2023-01-11', 9, 1, 'Vikings, The', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://booking.com',
        'Pellentesque at nulla. Suspendisse potenti.', '2021-11-18', '2023-02-18', 6, 1, 'Young Adult', 4, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://mozilla.com',
        'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis.',
        '2023-07-20', '2023-02-24', 5, 0, 'Des roses en hiver', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://freewebs.com',
        'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.',
        '2021-07-25', '2022-12-10', 6, 1, 'Public Access', 5, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://huffingtonpost.com',
        'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.',
        '2023-06-26', '2023-06-13', 3, 1, 'Cube', 4, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://ibm.com',
        'Etiam faucibus cursus urna. Ut tellus.', '2021-10-19', '2023-06-29', 1, 1, '$9.99', 3, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://biglobe.ne.jp',
         'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.',
        '2022-01-01', '2023-03-04', 5, 0, 'Eating Raoul', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://mit.edu',
        'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.',
        '2022-09-21', '2023-05-30', 1, 1, 'Punisher, The', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://4shared.com',
        'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',
        '2022-01-23', '2023-02-22', 3, 0, 'Laurence Anyways', 4, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://sbwire.com',
        'Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst.',
        '2023-09-12', '2023-07-31', 6, 0, 'Repast (Meshi)', 5, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://bigcartel.com',
        'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti.',
        '2021-07-23', '2023-01-24', 9, 1, 'Separate Lies', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://icio.us',
        'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.',
        '2022-06-12', '2023-08-23', 4, 0, 'Ice House, The', 2, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://live.com',
        'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus.',
        '2023-04-22', '2022-12-06', 3, 1, '13/13/13', 2, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://princeton.edu',
        'Proin eu mi. Nulla ac enim.', '2022-09-29', '2023-01-02', 1, 0, '42nd Street', 5, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'https://who.int',
        'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.',
        '2022-10-24', '2022-10-06', 4, 0, 'DarkWolf', 3, 2);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://altervista.org',
        'Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque.',
        '2022-05-14', '2023-08-13', 6, 1, 'Shun Li and the Poet', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'https://google.cn',
        'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat.',
        '2021-10-27', '2023-03-28', 10, 0, 'This Girl''s Life', 4, 1);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (0, 'http://census.gov',
        'Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.',
        '2022-04-02', '2023-02-05', 4, 0, 'My Name is Juani (Yo soy la Juani)', 3, 3);
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, title,
                  curriculum_id, member_id)
values (1, 'http://blogspot.com',
        'Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.',
        '2022-11-27', '2022-11-30', 2, 1, 'Interior. Leather Bar.', 3, 1);

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

-- comment
insert into comment (content, created_at, updated_at, post_id, member_id, PARENT_COMMENT_ID)
values ('댓글입니다.', '2023-08-07T10:30:15', '2023-08-07T10:30:15', 1,1, null),
       ('대댓글입니다.', '2023-08-07T10:31:00', '2023-08-07T10:31:00', 1,1, 1),
       ('댓글입니다.', '2023-08-07T10:31:20', '2023-08-07T10:31:20', 1,1, null);

UPDATE POST
SET STATUS = CASE
                 WHEN STATUS = 0 THEN 'RECRUITING'
                 WHEN STATUS = 1 THEN 'COMPLETED'
                 WHEN STATUS = 2 THEN 'DELETED'
                 ELSE STATUS
    END;

UPDATE POST
SET CLASSIFICATION = CASE
                         WHEN CLASSIFICATION = 0 THEN 'STUDY'
                         WHEN CLASSIFICATION = 1 THEN 'PROJECT'
                         ELSE CLASSIFICATION
    END;