
# Virtual Power Plant System

System for aggregating distributed power sources into
a single cloud based energy provider.

## Technologies used

Language: **Java**

Java Version: **17**

Database: **H2 in-memory**

## Setup project locally

Firstly, clone the project to your machine

```bash
  git clone https://github.com/gagan-here/vpps.git
```
Then go to the project directory

```bash
  cd vpps
```
Then install maven dependencies used in project

```bash
  mvn clean install
```
After successful build run following command:

```bash
  mvn spring-boot:run
```

## API Reference

### 1. Add batteries
```http
  POST /api/v1/batteries
```


| Variable | Type     | Required                |
| :-------- | :------- | :------------------------- |
| `name` | `String` |    Yes |
| `postcode` | `String` |  Yes|
| `wattCapacity` | `String` |  Yes|

#### Post Request JSON Body
```json
 [
    {
    "name": "Everyday",
    "postcode": "01234",
    "wattCapacity": "1000"
    },
    {
    "name": "Duracel",
    "postcode": "43210",
    "wattCapacity": "500"
    },
    {
    "name": "HW",
    "postcode": "98765",
    "wattCapacity": "2500"
    }
]

  ```
#### Response after successfully adding batteries
  ```json
   {
    "message": "Batteries added successfully."
    }
 ```

## 2. Get Statistics of batteries from given postcode range

```http
  GET /api/v1/batteries?from=postcodeRange1&to=postcodeRange2
```

| Parameter | Type     | Required | Description    |
| :-------- | :------- | :---------- |:---------------|
| `from`      | `int` |  Yes| postcodeRange1 |
| `to`      | `int` | Yes | postcodeRange2         |

#### Request

```http
  /api/v1/batteries?from=1000&to=3000
```

#### Response after successfully fetching batteries
```json
{
    "names": [
        "Everyday"
    ],
    "totalCapacity": 1000,
    "averageCapacity": 1000.0
}