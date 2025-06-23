import http from 'k6/http';
import { check, sleep } from 'k6';

/**
 * K6 Options
 * @see https://k6.io/docs/using-k6/k6-options/
 */
export const options = {
  stages: [
    { duration: '30s', target: 20 }, // Ramp-up to 20 virtual users over 30s
    { duration: '1m', target: 20 },  // Stay at 20 virtual users for 1 minute
    { duration: '10s', target: 0 },   // Ramp-down to 0 virtual users
  ],
  thresholds: {
    'http_req_duration': ['p(95)<500'], // 95% of requests must complete below 500ms
    'http_req_failed': ['rate<0.01'],   // Error rate must be less than 1%
  },
};

/**
 * Default function - represents the VU (Virtual User) logic.
 */
export default function () {
  const BASE_URL = 'https://reqres.in/api';

  // Test GET users
  const getRes = http.get(`${BASE_URL}/users?page=2`);
  check(getRes, {
    'GET /users status is 200': (r) => r.status === 200,
    'GET /users has data': (r) => r.json('data').length > 0,
  });

  sleep(1);

  // Test POST user
  const payload = JSON.stringify({
    name: 'morpheus',
    job: 'leader',
  });
  const params = {
    headers: {
      'Content-Type': 'application/json',
      'x-api-key': 'reqres-free-v1',
    },
  };
  const postRes = http.post(`${BASE_URL}/users`, payload, params);
  console.log('POST /users response:', postRes.status, postRes.body);
  check(postRes, {
    'POST /users status is 201': (r) => r.status === 201,
    'POST /users has name': (r) => r.json('name') === 'morpheus',
  });

  sleep(1);
} 