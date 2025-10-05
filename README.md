# 🇧🇷 MCP CEP Server

Servidor Model Context Protocol (MCP) para consulta de CEPs brasileiros e cálculo de distâncias entre endereços.

## ✨ Funcionalidades

- 📍 **Consulta de CEP**: Busca detalhada de endereços brasileiros via CEP
- 🗺️ **Geocodificação**: Conversão precisa de endereços em coordenadas geográficas  
- 📏 **Matriz de Distâncias**: Cálculo de distâncias e tempo de viagem entre localidades
- ⏱️ **Estimativas de Tempo**: Tempo estimado de deslocamento entre pontos
- 🎯 **Dados Oficiais**: Utiliza informações dos Correios e APIs de geolocalização

## 🔧 Tools Disponíveis

### `cep_address_details`
Busca informações completas de um endereço a partir do CEP.

**Parâmetros:**
- `cep` (string): CEP brasileiro (com ou sem hífen)

**Retorna:**
- Logradouro, bairro, cidade, UF, estado, região
- Código IBGE, DDD, SIAFI

### `geocode_accurate` 
Obtém coordenadas geográficas precisas de um endereço.

**Parâmetros:**
- `address` (string): Endereço completo

**Retorna:**
- Latitude e longitude precisas

### `distance_matrix_accurate`
Calcula matriz de distâncias entre origens e destinos.

**Parâmetros:**
- `origins` (string): Endereços de origem
- `destinations` (string): Endereços de destino  

**Retorna:**
- Distância em km e metros
- Tempo estimado de viagem
- Status da operação

## 🚀 Como Usar

Este servidor MCP pode ser integrado com clientes compatíveis como Claude Desktop, VS Code ou outras ferramentas que suportem o protocolo MCP.

## 🌎 Cobertura

- ✅ Todos os CEPs brasileiros
- ✅ Capitais e interior
- ✅ Endereços urbanos e rurais
- ✅ Dados atualizados dos Correios

## 📊 Exemplo de Uso

```json
// Consulta de CEP
{
  "cep": "01310-100",
  "logradouro": "Avenida Paulista",
  "bairro": "Bela Vista", 
  "localidade": "São Paulo",
  "uf": "SP"
}

// Matriz de distância
{
  "distance": "15.2 km",
  "duration": "23 mins"
}
