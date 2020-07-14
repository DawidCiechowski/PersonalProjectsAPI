# Dawid Ciechowski Personal Projects API

1. [ Description. ](#desc)
2. [ Usage tips. ](#usage)

<a name="desc"></a>
## 1. Description

sometext

<a name="usage"></a>
## 2. Usage tips

sometext

## Table of Contents

* [ Introduction ](#Introduction)
* [ Technologies ](#Technologies)
* [ Usage ](#Usage)

<a name="Introduction"></a>
## Introduction

Projects API is a personally created API, hosted on Amazon Web Services, which can be used to obtain information about
my personal projects, which I've been working on over the years. 

<a name="Technologies"></a>
## Technologies

- Java 11
- SpringBoot 2.3.1
- JavaX Persistence 2.2
- PostgreSQL 42.2.14
- AWS Elastic Beanstalk

<a name="Usage"></a>
## Usage

### GET Request for ALL projects

```
curl dawid-ciechowski.eu-west-2.elasticbeanstalk.com/api/v1/projects
```

### GET Request for a SINGLE project

```

curl dawid-ciechowski.eu-west-2.elasticbeanstalk.com/api/v1/projects/{project_id}
```

