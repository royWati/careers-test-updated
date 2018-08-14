
INSERT INTO job_types(ID,name,code,version,date_column) VALUES
  ('868b5b0b2f474d01ba195a5eb4785962','data analyist','DA',0,now());
INSERT INTO job_types(ID,name,code,version,date_column) VALUES
  ('53511c709d77400cae95ebaea69d3f82','backend developer','DB',0,now());
INSERT INTO job_types(ID,name,code,version,date_column) VALUES
  ('7a5d7ea9739f4ef4bc125d182af50ff7','frontend developer','FD',0,now());
INSERT INTO job_types(ID,name,code,version,date_column) VALUES
  ('ba6a784ab9b544cebeb33bab7ef8b4b9','system architect','SA',0,now());


INSERT INTO jobs(ID,job_name,job_type_id,description,years_of_experience,
status,interview_start_date,interview_end_time,version,date_column) VALUES
('7a6a792ab9b544cebeb33bab7ef8b4b9','data engineer','868b5b0b2f474d01ba195a5eb4785962','build data models','3',
'open','2018-08-14 13:00:00','2018-08-14 16:00:00',0,now());
INSERT INTO jobs(ID,job_name,job_type_id,description,years_of_experience,
                 status,interview_start_date,interview_end_time,version,date_column) VALUES
  ('9a6a784ab9b544cebeb33bab7ef8b4b9','java backend','53511c709d77400cae95ebaea69d3f82','build rest apis using spring boot application framework','3',
   'open','2018-08-14 13:00:00','2018-08-14 16:00:00',0,now());

INSERT INTO jobs(ID,job_name,job_type_id,description,years_of_experience,
                 status,interview_start_date,interview_end_time,version,date_column) VALUES
  ('9a6a700ab9b544cebeb33bab7ef8b4b9','php architect','ba6a784ab9b544cebeb33bab7ef8b4b9','design systems that run in php frameworks','3',
   'open','2018-08-14 13:00:00','2018-08-14 16:00:00',0,now());

