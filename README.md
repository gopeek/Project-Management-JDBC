# Poised project management system


### A java project used to keep track of the many projects held by Poised

###### projects have 3 main components

> project details

| Project number        | Project name           | Type of building  | Physical address of project        | ERF number           | total project fee  | total amount paid to date  | Project deadline  |
| ------------- |-------------| -----| ------------- |-------------| -----| -----| -----|


> Project architect

| Name        | Telephone number           | email address  | physical address        |
| ------------- |-------------| -----| ------------- |


> Project contractor

| Name        | Telephone number           | email address  | physical address        |
| ------------- |-------------| -----| ------------- |


> Project customer

| Name        | Telephone number           | email address  | physical address        |
| ------------- |-------------| -----| ------------- |


```java
//libraries used

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
```

> project instructions


- Capture information about new projects. If a project name is not provided when the information is captured, name the project using the surname of the customer
- Update information about existing projects
- finalise project
⋅⋅⋅ Generate invoice for customer
⋅⋅⋅ mark project as finalised
- see list of projects that still need to be completed
- see list of projects that are past due date
- Find and select a project

