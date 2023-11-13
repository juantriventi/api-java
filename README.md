

# API JAVA || SPRING BOOT

Una Api para crear usuarios y asignarles roles desde postman con una base de datos h2.
## Usuarios

#### Traer Usuarios

```http
  GET /usuario/listar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

No se le pasan parametros.

#### Crear Usuario

```http
  POST /usuario/crear
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`  | `string` | **Required**. |
| `apellido`| `string` | **Required**. |
| `rol`     | `Long` | **Required**. |

```http
  PUT /usuario/editar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`  | `Long` | **Required**. |
| `nombre`  | `string` | **Required**. |
| `apellido`| `string` | **Required**. |
| `rol`     | `Long` | **Required**. |


```http
  POST /usuario/eliminar/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

No se le pasan parametros por el body, solamente el id del usuario por path usando el metodo POST.


## Roles

#### Traer roles

```http
  GET /rol/listar
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

No se le pasan parametros.
