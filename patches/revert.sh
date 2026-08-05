#!/usr/bin/env bash
set -euo pipefail

FIX_COMMIT="${1:-c67fc65b40cd0df19bf263774f27006b9d34b445}"

echo "==> Reverting mytai20100 fix commit ${FIX_COMMIT} (source only, patches/ kept)"
git revert --no-commit "$FIX_COMMIT"
git restore --staged --source=HEAD -- patches/ 2>/dev/null || true
git restore --source=HEAD -- patches/ 2>/dev/null || true
git commit -m "revert: undo mytai20100 fix ${FIX_COMMIT}"
echo "==> Done. Source restored to pre-fix state; patches/*.patch untouched."
