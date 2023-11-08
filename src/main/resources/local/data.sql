-- 커리큘럼 5개 생성
insert into curriculum (curriculum_id, created_at, updated_at , name) values (1, '2023-01-03', '2023-01-03', '전체');
insert into curriculum (curriculum_id, created_at, updated_at , name) values (2, '2023-01-03', '2023-01-03', '풀스택');
insert into curriculum (curriculum_id, created_at, updated_at , name) values (3, '2023-01-03', '2023-01-03', '정보 보안 과정');
insert into curriculum (curriculum_id, created_at, updated_at , name) values (4, '2023-01-03', '2023-01-03', '쿠버네티스 과정');
insert into curriculum (curriculum_id, created_at, updated_at , name) values (5, '2023-01-03', '2023-01-03', 'AI자연어처리 과정');

-- 멤버 3개 생성  123456789!
insert into member ( account_id, created_at,updated_at, name, password) values ( 'hello1','2023-01-03', '2023-01-03', '홍길동(풀스택 2회차)', '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');
insert into member ( account_id, created_at,updated_at, name, password) values ( 'hello2','2023-01-03', '2023-01-03', '아무개(풀스택 2회차)', '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');
insert into member ( account_id, created_at,updated_at, name, password) values ( 'hello3','2023-01-03', '2023-01-03', '김밥(풀스택 2회차)', '$2a$10$lJEBlvPmFxvc0aad.SKOfeAhzaIuaxu.IoFHfycyt./8Sc697/1D6');

-- post 데이터 30개
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://storify.com', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '2023-01-10', '2023-07-19', 2, 1, '면접, 프론트엔드, 데브옵스', 'House at the End of the Street', 1, 1, 'spring, frontend, react, javascript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://zimbio.com', 'Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', '2022-06-12', '2023-07-11', 4, 0, 'CS, 코딩테스트', 'Hurricane, The', 2, 3, 'frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://netlog.com', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti.', '2023-05-12', '2023-04-21', 6, 1, 'CS, 프론트엔드', 'Milwaukee, Minnesota', 5, 1, 'spring, backend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://omniture.com', 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', '2023-03-29', '2023-02-13', 10, 0, '면접, CS, 프론트엔드', 'Brink''s Job, The', 3, 3, 'ai, spring, backend, python');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://ft.com', 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '2022-10-02', '2023-03-12', 9, 1, '면접, 데브옵스', 'Volver', 3, 1, 'python, frontend, react');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://youku.com', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum.', '2021-09-23', '2023-02-10', 9, 0, '프론트엔드, 면접, 코딩테스트', 'Cherrybomb', 2, 1, 'java, ai, javascript, python');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://nydailynews.com', 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '2023-01-12', '2022-12-07', 9, 0, '백엔드, 면접, 데브옵스', 'Return to Me', 1, 1, 'react, typescript, python');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://toplist.cz', 'Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', '2023-02-12', '2022-10-08', 2, 0, '면접', 'Head Over Heels (De Pernas pro Ar)', 2, 2, 'spring, java, frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://drupal.org', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2023-02-04', '2023-06-12', 7, 1, '백엔드', 'Shirley Valentine', 5, 2, 'frontend, backend, ai, java, javascript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://so-net.ne.jp', 'Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '2021-10-31', '2023-04-28', 4, 0, '코딩테스트', 'Randy and the Mob', 4, 3, 'java, python, typescript, spring');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://wordpress.org', 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat.', '2022-10-03', '2023-03-07', 8, 0, 'CS, 프론트엔드', 'Million Dollar Legs', 5, 1, 'typescript, ai, spring, javascript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://plala.or.jp', 'Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.', '2022-10-15', '2022-10-25', 5, 0, '프론트엔드', 'Castles in the Sky', 2, 1, 'backend, react, typescript, spring');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://yellowpages.com', 'Morbi quis tortor id nulla ultrices aliquet.', '2021-12-19', '2023-06-02', 8, 1, '백엔드', 'Kid Millions', 3, 1, 'frontend, react, javascript, java');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://marketwatch.com', 'Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.', '2022-11-20', '2023-05-08', 5, 1, 'CS, 면접, 데브옵스', 'Immensee', 3, 3, 'typescript, ai');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'http://godaddy.com', 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '2022-07-06', '2023-04-22', 5, 1, '코딩테스트', 'Love Meetings (Comizi d''amore)', 5, 2, 'ai');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://alibaba.com', 'Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.', '2022-08-12', '2023-04-24', 7, 0, '백엔드', 'Same Old Song (On connaît la chanson)', 3, 1, 'frontend, ai, python, typescript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://cdc.gov', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.', '2023-06-17', '2022-11-21', 1, 0, '데브옵스, 코딩테스트', 'Ms. 45 (a.k.a. Angel of Vengeance)', 1, 1, 'java, typescript, backend, javascript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://123-reg.co.uk', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2023-07-14', '2023-01-14', 4, 0, '백엔드, 프론트엔드', 'Mustasukkaisuus', 2, 2, 'ai, typescript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://tuttocitta.it', 'Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', '2022-10-24', '2023-08-05', 2, 0, 'CS, 프론트엔드', 'Source Code', 5, 3, 'backend, frontend, ai, react, typescript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://fastcompany.com', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2022-08-16', '2022-12-11', 1, 1, 'CS, 면접, 프론트엔드', 'Uprising', 5, 1, 'typescript, react, spring, backend, frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://ibm.com', 'Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', '2022-03-20', '2022-11-25', 10, 1, '프론트엔드, 데브옵스, CS', 'Heart of a Dog (Sobachye serdtse)', 3, 1, 'frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://dailymail.co.uk', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper sapien a libero. Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis.', '2021-10-20', '2023-01-24', 5, 1, '코딩테스트', 'House on Carroll Street, The', 5, 2, 'react, frontend, typescript, javascript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://last.fm', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2023-04-07', '2023-07-15', 6, 0, '프론트엔드, 데브옵스, 백엔드', 'Bonjour Monsieur Shlomi (Ha-Kochavim Shel Shlomi)', 3, 1, 'spring, react, java, typescript, frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://histats.com', 'Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.', '2023-06-10', '2023-09-10', 8, 0, '코딩테스트', 'The Power and the Glory', 1, 2, 'javascript, backend, ai, react, python');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'http://google.pl', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.', '2023-02-19', '2023-05-22', 5, 0, 'CS, 면접, 코딩테스트', 'Lady and the Duke, The (Anglaise et le duc, L'')', 3, 2, 'typescript, spring, javascript, backend, react');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://sfgate.com', 'Proin interdum mauris non ligula pellentesque ultrices.', '2023-06-09', '2022-10-26', 9, 0, '프론트엔드, 코딩테스트', 'Win Win', 5, 2, 'react, python');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'https://ed.gov', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '2022-04-10', '2022-10-27', 9, 0, '면접, 프론트엔드, 데브옵스', 'Light It Up', 1, 2, 'typescript');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (0, 'http://disqus.com', 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '2023-06-02', '2023-03-05', 3, 1, '면접', 'Man of the East', 4, 1, 'spring, java');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'http://bigcartel.com', 'In blandit ultrices enim.', '2023-08-07', '2022-12-21', 3, 0, '프론트엔드', 'Shadow of Angels (Schatten der Engel)', 2, 3, 'backend, react, spring, frontend');
insert into post (classification, contact_url, content, created_at, updated_at, recruit_num, status, subject, title, curriculum_id, member_id, stack) values (1, 'https://seesaa.net', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2023-06-01', '2023-09-01', 6, 1, '프론트엔드', 'Last Horror Movie, The', 3, 1, 'java, react, ai, spring');