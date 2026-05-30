create database CTS;
use CTS;
create table Users(user_id int primary key auto_increment,full_name varchar(100) not null,email varchar(100) unique not null,city varchar(100) not null,registration_date Date not null);
create table Events(event_id int primary key auto_increment,title varchar(200) not null,description text,city varchar(100) not null,start_date Datetime not null,end_date datetime not null,status enum('upcoming','completed','cancelled'),organizer_id int ,foreign key(organizer_id) references Users(user_id));
create table Sessions(session_id int primary key Auto_increment,event_id int,title varchar(200) not null,speaker_name varchar(100) not null,start_time datetime not null,end_time datetime not null,foreign key(event_id) references Events(event_id));
create table Registrations(registration_id int primary key auto_increment,user_id int,event_id int,registration_date date not null,foreign key(user_id) references Users(user_id),foreign key(event_id) references Events(event_id));
create table Feedback(feedback_id int primary key auto_increment,user_id int,event_id int,rating int,comments text,feedback_date date not null,foreign key(user_id) references Users(user_id),foreign key(event_id) references Events(event_id),check(rating between 1 and 5));
drop table Feedback;
create table Resources(resource_id int primary key auto_increment,event_id int ,resource_type enum('pdf','image','link'),resource_url varchar(255) not null,uploaded_at datetime not null,foreign key(event_id) references Events(event_id));
INSERT INTO Users (full_name, email, city, registration_date) VALUES
('Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
('Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
('Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
('Diana King', 'diana@example.com', 'New York', '2025-01-15'),
('Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');


INSERT INTO Events
(title, description, city, start_date, end_date, status, organizer_id)
VALUES
('Tech Innovators Meetup',
'A meetup for tech enthusiasts.',
'New York',
'2025-06-10 10:00:00',
'2025-06-10 16:00:00',
'upcoming',
1),

('AI & ML Conference',
'Conference on AI and ML advancements.',
'Chicago',
'2025-05-15 09:00:00',
'2025-05-15 17:00:00',
'completed',
3),

('Frontend Development Bootcamp',
'Hands-on training on frontend tech.',
'Los Angeles',
'2025-07-01 10:00:00',
'2025-07-03 16:00:00',
'upcoming',
2);


INSERT INTO Sessions
(event_id, title, speaker_name, start_time, end_time)
VALUES
(1,
'Opening Keynote',
'Dr. Tech',
'2025-06-10 10:00:00',
'2025-06-10 11:00:00'),

(1,
'Future of Web Dev',
'Alice Johnson',
'2025-06-10 11:15:00',
'2025-06-10 12:30:00'),

(2,
'AI in Healthcare',
'Charlie Lee',
'2025-05-15 09:30:00',
'2025-05-15 11:00:00'),

(3,
'Intro to HTML5',
'Bob Smith',
'2025-07-01 10:00:00',
'2025-07-01 12:00:00');


INSERT INTO Registrations
(user_id, event_id, registration_date)
VALUES
(1, 1, '2025-05-01'),
(2, 1, '2025-05-02'),
(3, 2, '2025-04-30'),
(4, 2, '2025-04-28'),
(5, 3, '2025-06-15');


INSERT INTO Feedback
(user_id, event_id, rating, comments, feedback_date)
VALUES
(3, 2, 4, 'Great insights!', '2025-05-16'),
(4, 2, 5, 'Very informative.', '2025-05-16'),
(2, 1, 3, 'Could be better.', '2025-06-11');

INSERT INTO Resources
(event_id, resource_type, resource_url, uploaded_at)
VALUES
(1,
'pdf',
'https://portal.com/resources/tech_meetup_agenda.pdf',
'2025-05-01 10:00:00'),

(2,
'image',
'https://portal.com/resources/ai_poster.jpg',
'2025-04-20 09:00:00'),

(3,
'link',
'https://portal.com/resources/html5_docs',
'2025-06-25 15:00:00');

SELECT * FROM Users;
SELECT * FROM Events;
SELECT * FROM Sessions;
SELECT * FROM Registrations;
SELECT * FROM Feedback;
SELECT * FROM Resources;

-- 1st Quesn 

SELECT full_name, title, e.city, start_date
FROM Users u
JOIN Registrations r
ON u.user_id = r.user_id
JOIN Events e
ON r.event_id = e.event_id
WHERE status = 'upcoming'
AND u.city = e.city
ORDER BY start_date;

-- 2nd Quesn

SELECT e.event_id,
       e.title,
       AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f
ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;

-- 3rd Quesn

SELECT u.user_id,
       u.full_name
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.user_id IS NULL;

-- 4th quesn

SELECT e.title,
       COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s
ON e.event_id = s.event_id
WHERE TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY e.event_id, e.title;

-- 5th Quesn

SELECT u.city,
       COUNT(DISTINCT u.user_id) AS total_users
FROM Users u
JOIN Registrations r
ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY total_users DESC
LIMIT 5;

-- 6th Quesn

SELECT e.title,
       COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r
ON e.event_id = r.event_id
GROUP BY e.event_id, e.title;

-- 7th Quesn

SELECT u.full_name,
       f.comments,
       e.title
FROM Users u
JOIN Feedback f
ON u.user_id = f.user_id
JOIN Events e
ON f.event_id = e.event_id
WHERE f.rating < 3;

-- 8th Quesn

SELECT e.title,
       COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s
ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;

-- 9th Quesn

SELECT u.full_name,
       e.status,
       COUNT(e.event_id) AS total_events
FROM Users u
JOIN Events e
ON u.user_id = e.organizer_id
GROUP BY u.full_name, e.status;

-- 10th Quesn

SELECT e.title
FROM Events e
JOIN Registrations r
ON e.event_id = r.event_id
LEFT JOIN Feedback f
ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title;

-- 11th Quesn

SELECT registration_date,
       COUNT(*) AS total_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date;

-- 12th Quesn

SELECT e.title,
       COUNT(s.session_id) AS total_sessions
FROM Events e
JOIN Sessions s
ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(session_count)
    FROM (
        SELECT COUNT(*) AS session_count
        FROM Sessions
        GROUP BY event_id
    ) t
);

-- 13th Quesn

SELECT e.city,
       AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f
ON e.event_id = f.event_id
GROUP BY e.city;

-- 14th Quesn

SELECT e.title,
       COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r
ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;

-- 15th Quesn

SELECT s1.event_id,
       s1.title,
       s2.title
FROM Sessions s1
JOIN Sessions s2
ON s1.event_id = s2.event_id
AND s1.session_id < s2.session_id
AND s1.start_time < s2.end_time
AND s1.end_time > s2.start_time;

-- 16th Quesn

SELECT u.full_name
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
AND r.registration_id IS NULL;

-- 17th Quesn

SELECT speaker_name,
       COUNT(*) AS total_sessions
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;

-- 18th Quesn

SELECT e.title
FROM Events e
LEFT JOIN Resources r
ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

-- 19th Quesn

SELECT e.title,
       COUNT(DISTINCT r.registration_id) AS total_registrations,
       AVG(f.rating) AS avg_rating
FROM Events e
LEFT JOIN Registrations r
ON e.event_id = r.event_id
LEFT JOIN Feedback f
ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title;

-- 20th Quesn

SELECT u.full_name,
       COUNT(DISTINCT r.event_id) AS attended_events,
       COUNT(DISTINCT f.feedback_id) AS feedback_count
FROM Users u
LEFT JOIN Registrations r
ON u.user_id = r.user_id
LEFT JOIN Feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name;

-- 21st Quesn

SELECT u.full_name,
       COUNT(f.feedback_id) AS total_feedbacks
FROM Users u
JOIN Feedback f
ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY total_feedbacks DESC
LIMIT 5;

-- 22nd Quesn

SELECT user_id,
       event_id,
       COUNT(*) AS duplicate_count
FROM Registrations
GROUP BY user_id, event_id
HAVING COUNT(*) > 1;

-- 23rd Quesn

SELECT MONTH(registration_date) AS month,
       COUNT(*) AS total_registrations
FROM Registrations
WHERE registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY MONTH(registration_date)
ORDER BY month;

-- 24th Quesn

SELECT e.title,
       AVG(TIMESTAMPDIFF(MINUTE,
                         s.start_time,
                         s.end_time)) AS avg_duration
FROM Events e
JOIN Sessions s
ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;

-- 25th Quesn

SELECT e.title
FROM Events e
LEFT JOIN Sessions s
ON e.event_id = s.event_id
WHERE s.session_id IS NULL;

